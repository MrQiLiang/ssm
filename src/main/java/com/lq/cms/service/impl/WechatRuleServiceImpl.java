package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.emun.WechatKeywordMatchinTypeEnum;
import com.lq.cms.emun.WechatRuleReplyTypeEnum;
import com.lq.cms.service.WechatRuleService;
import com.lq.cms.vo.WechatRuleVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.code.util.BeanUtil;
import com.lq.dao.WechatKeywordDao;
import com.lq.dao.WechatMessageDao;
import com.lq.dao.WechatRuleDao;
import com.lq.dao.WechatRuleMessageDao;
import com.lq.entity.*;
import com.lq.wechat.mode.message.BaseMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 5:55 AM 2019/5/11
 */
@Service
public class WechatRuleServiceImpl extends BaseServiceImpl<WechatRule> implements WechatRuleService {

    @Autowired
    private WechatRuleDao wechatRuleDao;
    @Autowired
    private WechatKeywordDao wechatKeywordDao;
    @Autowired
    private WechatRuleMessageDao wechatRuleMessageDao;
    @Autowired
    private WechatMessageDao wechatMessageDao;


    @Override
    public BaseMessage getByKeyworkdAndWechatInfoId(String keyworkd, WechatInfo wechatInfo) {

        List<WechatMessage> wechatMessageList = new ArrayList<>();
        //公众号相关回复规则
        List<WechatRule> wechatRuleList = wechatRuleDao.findByWechatInfoIdAndStatus(wechatInfo.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        wechatRuleList.forEach((wechatRule)->{
            //规则相关关键词
            List<WechatKeyword> wechatKeywordList = wechatKeywordDao.findByWechatRuleIdAndStatus(wechatRule.getId(),StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            wechatKeywordList.forEach((wechatKeyword)->{
                if (WechatKeywordMatchinTypeEnum.KEYWORD_ALL.getValue().equals(wechatKeyword.getMatchinType())){
                    if (keyworkd.equals(wechatKeyword.getKeyword())){
                       List<WechatRuleMessage> wechatRuleMessageList = wechatRuleMessageDao.findByWechatRuleId(wechatRule.getId());
                       if (WechatRuleReplyTypeEnum.REPLY_ALL.getValue().equals(wechatRule.getReplyType())) {
                           wechatRuleMessageList.forEach((wechatRuleMessage) -> {
                               WechatMessage wechatMessage = wechatMessageDao.findOne(wechatRuleMessage.getId());
                               if (wechatMessage != null) {
                                   wechatMessageList.add(wechatMessage);
                               }
                           });
                       }
                       if (WechatRuleReplyTypeEnum.REPLY_RANDOM.getValue().equals(wechatRule.getReplyType())){
                           ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
                           int index = ThreadLocalRandom.current().nextInt(wechatRuleMessageList.size());
                           WechatRuleMessage wechatRuleMessage = wechatRuleMessageList.get(index);
                           WechatMessage wechatMessage = wechatMessageDao.findOne(wechatRuleMessage.getId());
                           wechatMessageList.add(wechatMessage);
                       }
                    }
                }else {
                    if (keyworkd.indexOf(wechatKeyword.getKeyword())!=-1){
                        List<WechatRuleMessage> wechatRuleMessageList = wechatRuleMessageDao.findByWechatRuleId(wechatRule.getId());
                        if (WechatRuleReplyTypeEnum.REPLY_ALL.getValue().equals(wechatRule.getReplyType())) {
                            wechatRuleMessageList.forEach((wechatRuleMessage) -> {
                                WechatMessage wechatMessage = wechatMessageDao.findOne(wechatRuleMessage.getId());
                                if (wechatMessage != null) {
                                    wechatMessageList.add(wechatMessage);
                                }
                            });
                        }
                        if (WechatRuleReplyTypeEnum.REPLY_RANDOM.getValue().equals(wechatRule.getReplyType())){
                            ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
                            int index = ThreadLocalRandom.current().nextInt(wechatRuleMessageList.size());
                            WechatRuleMessage wechatRuleMessage = wechatRuleMessageList.get(index);
                            WechatMessage wechatMessage = wechatMessageDao.findOne(wechatRuleMessage.getId());
                            wechatMessageList.add(wechatMessage);
                        }
                    }
                }

            });
        });
        BaseMessage baseMessage = null;

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
