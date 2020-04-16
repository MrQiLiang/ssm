package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.emun.WechatKeywordMatchinTypeEnum;
import com.lq.cms.emun.WechatMessageTypeEnum;
import com.lq.cms.service.WechatRuleService;
import com.lq.cms.vo.WechatRuleVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.util.BeanUtil;
import com.lq.dao.WechatKeywordDao;
import com.lq.dao.WechatMessageDao;
import com.lq.dao.WechatRuleDao;
import com.lq.dao.WechatRuleMessageDao;
import com.lq.entity.*;
import com.lq.wechat.mode.message.BaseMessage;
import com.lq.wechat.mode.message.ImageMessage;
import com.lq.wechat.mode.message.NewsMessage;
import com.lq.wechat.mode.message.TextMessage;
import com.lq.wechat.util.ConstantSet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 5:55 AM 2019/5/11
 */
@Service
public class WechatRuleServiceImpl  implements WechatRuleService {

    @Autowired
    private WechatRuleDao wechatRuleDao;
    @Autowired
    private WechatKeywordDao wechatKeywordDao;
    @Autowired
    private WechatRuleMessageDao wechatRuleMessageDao;
    @Autowired
    private WechatMessageDao wechatMessageDao;


    @Override
    public BaseMessage getByKeyworkdAndWechatInfoId(String keyWord, WechatInfo wechatInfo) {
        AtomicReference<WechatMessage> wechatMessageAtomicReference = new AtomicReference<>();
        List<WechatRule> wechatRuleList = wechatRuleDao.findByWechatInfoIdAndStatus(wechatInfo.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRuleList.forEach((wechatRule)->{
            List<WechatKeyword> wechatKeywordList = wechatKeywordDao.findByWechatRuleIdAndStatus(wechatRule.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeywordList.forEach(wechatKeyword -> {
                if (WechatKeywordMatchinTypeEnum.KEYWORD_ALL.getValue().equals( wechatKeyword.getMatchinType())){
                    if (wechatKeyword.getKeyword().equals(keyWord)){
                        WechatMessage wechatMessage = wechatMessageDao.findByRuleId(wechatRule.getId());
                        wechatMessageAtomicReference.set(wechatMessage);
                    }
                }
            });
            List<WechatRuleMessage> wechatRuleMessageList = wechatRuleMessageDao.findByWechatRuleId(wechatRule.getId());
            if (wechatRuleMessageList!=null&&wechatRuleMessageList.size()>0) {
                wechatMessageAtomicReference.set(wechatMessageDao.findOne(wechatRuleMessageList.get(0).getWechatMessageId()));
            }
        });
        WechatMessage wechatMessage = wechatMessageAtomicReference.get();
        BaseMessage baseMessage = null;
        if (WechatMessageTypeEnum.TEXT.getValue().equals(wechatMessage.getMessageType())){
            TextMessage textMessags = new TextMessage();
            textMessags.setMsgType(ConstantSet.MESSAGE_TYPE_TEXT);
            textMessags.setContent(wechatMessage.getContent());
            baseMessage = textMessags;
        }
        if (WechatMessageTypeEnum.IMAGE.getValue().equals(wechatMessage.getMessageType())){
            ImageMessage imageMessage = new ImageMessage();
            imageMessage.setPicUrl(wechatMessage.getImageUrl());
            baseMessage = imageMessage;
        }
        if (WechatMessageTypeEnum.IMAGE_TEXT.getValue().equals(wechatMessage.getMessageType())){
            NewsMessage newsMessage = new NewsMessage();
        }
        return baseMessage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public WechatRule saveRuleAndkeyword(WechatRule wechatRule, List<WechatKeyword> wechatKeywordList) {
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        wechatRule.setCreateUserId(loginUser.getId());
        wechatRule.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRule.setCreateTime(new Date());
        wechatRuleDao.save(wechatRule);
        wechatKeywordList.forEach(wechatKeyword -> {
            wechatKeyword.setCreateTime(new Date());
            wechatKeyword.setWechatRuleId(wechatRule.getId());
            wechatKeyword.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeywordDao.save(wechatKeyword);
        });
        return wechatRule;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public WechatRule saveRule(WechatRuleVo wechatRuleVo) {
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        WechatRule wechatRule = new WechatRule();
        BeanUtil.copyNotNull(wechatRule,wechatRuleVo);
        wechatRule.setCreateUserId(loginUser.getId());
        wechatRule.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRule.setCreateTime(new Date());
        wechatRuleDao.save(wechatRule);

        List<WechatKeyword> wechatKeywordList = wechatRuleVo.getWechatKeywordList();
        wechatKeywordList.forEach(wechatKeyword -> {
            wechatKeyword.setCreateTime(new Date());
            wechatKeyword.setWechatRuleId(wechatRule.getId());
            wechatKeyword.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeywordDao.save(wechatKeyword);
        });

        List<Long> messageIds = wechatRuleVo.getMessageIds();
        messageIds.forEach((messageId)->{
            WechatRuleMessage wechatRuleMessage = wechatRuleMessageDao.getByRuleIdAndMessageId(wechatRule.getId(),messageId);
            if (wechatRuleMessage==null){
                wechatRuleMessage = new WechatRuleMessage();
                wechatRuleMessage.setCreateTime(new Date());
                wechatRuleMessage.setWechatMessageId(messageId);
                wechatRuleMessage.setWechatRuleId(wechatRule.getId());
                wechatRuleMessage.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                wechatRuleMessageDao.save(wechatRuleMessage);
            }
        });

        return wechatRule;
    }

    @Override
    public WechatRule updateRule(WechatRuleVo wechatRuleVo) {
        Subject subject= SecurityUtils.getSubject();
        SysUser loginUser=(SysUser) subject.getPrincipal();
        WechatRule wechatRule = wechatRuleDao.findOne(wechatRuleVo.getId());
        BeanUtil.copyNotNull(wechatRule,wechatRuleVo);
        wechatRule.setCreateUserId(loginUser.getId());
        wechatRule.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRule.setCreateTime(new Date());
        wechatRuleDao.update(wechatRule);
        wechatKeywordDao.deleteByWechatRuleId(wechatRule.getId());
        List<WechatKeyword> wechatKeywordList = wechatRuleVo.getWechatKeywordList();
        wechatKeywordList.forEach(wechatKeyword -> {
            wechatKeyword.setWechatRuleId(wechatRule.getId());
            wechatKeyword.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeyword.setCreateTime(new Date());
            wechatKeywordDao.save(wechatKeyword);
        });

        List<Long> messageIds = wechatRuleVo.getMessageIds();
        //删除消息与规则关联关系
        wechatRuleMessageDao.deleteByWechatRuleId(wechatRule.getId());
        messageIds.forEach((messageId)->{
            WechatRuleMessage wechatRuleMessage = wechatRuleMessageDao.getByRuleIdAndMessageId(wechatRule.getId(),messageId);
            if (wechatRuleMessage==null){
                wechatRuleMessage = new WechatRuleMessage();
                wechatRuleMessage.setCreateTime(new Date());
                wechatRuleMessage.setWechatMessageId(messageId);
                wechatRuleMessage.setWechatRuleId(wechatRule.getId());
                wechatRuleMessage.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
                wechatRuleMessageDao.save(wechatRuleMessage);
            }
        });

        return wechatRule;
    }


    @Override
    public List<WechatRuleVo> findByWechatInfoId(Long wechatInfoId) {
        List<WechatRuleVo> wechatRuleVos = new ArrayList<>();
        List<WechatRule> wechatRuleList = wechatRuleDao.findByWechatInfoIdAndStatus(wechatInfoId,StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRuleList.forEach(wechatRule -> {
            WechatRuleVo wechatRuleVo = new WechatRuleVo();
            BeanUtil.copyNotNull(wechatRuleVo,wechatRule);
            List<WechatKeyword> wechatKeywordList = wechatKeywordDao.findByWechatRuleIdAndStatus(wechatRule.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatRuleVo.setWechatKeywordList(wechatKeywordList);
            wechatRuleVos.add(wechatRuleVo);
        });

        return wechatRuleVos;
    }

    @Override
    public WechatRuleVo getWechatRuleVoById(Long wechatRuleId) {
        WechatRule wechatRule = wechatRuleDao.findOne(wechatRuleId);
        WechatRuleVo wechatRuleVo = new WechatRuleVo();
        BeanUtil.copyNotNull(wechatRuleVo,wechatRule);
        List<WechatKeyword> wechatKeywordList = wechatKeywordDao.findByWechatRuleIdAndStatus(wechatRule.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        List<WechatRuleMessage> wechatRuleMessageList = wechatRuleMessageDao.findByWechatRuleId(wechatRuleId);
        if (wechatRuleMessageList!=null&&wechatRuleMessageList.size()>0){
            List<Long> wechatMessageIds = new ArrayList<>();
            wechatRuleMessageList.forEach((wechatRuleMessage)->{
                wechatMessageIds.add(wechatRuleMessage.getWechatMessageId());
            });
            wechatRuleVo.setMessageIds(wechatMessageIds);
        }
        wechatRuleVo.setWechatKeywordList(wechatKeywordList);
        return wechatRuleVo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteWechatRuleById(Long id) {
        WechatRule wechatRule = wechatRuleDao.findOne(id);
        if (wechatRule!=null){
            List<WechatKeyword> wechatKeywordList = wechatKeywordDao.findByWechatRuleIdAndStatus(id,StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeywordList.forEach(wechatKeyword -> {
                wechatKeywordDao.delete(wechatKeyword.getId());
            });
            wechatRuleDao.delete(id);
        }

    }

    @Override
    public BaseDao<WechatRule> getBaseDao() {
        return wechatRuleDao;
    }
}
