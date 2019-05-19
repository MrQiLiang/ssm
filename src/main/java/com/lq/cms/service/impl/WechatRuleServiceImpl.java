package com.lq.cms.service.impl;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.WechatRuleService;
import com.lq.cms.vo.WechatRuleVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.code.util.BeanUtil;
import com.lq.dao.WechatKeywordDao;
import com.lq.dao.WechatRuleDao;
import com.lq.entity.SysUser;
import com.lq.entity.WechatInfo;
import com.lq.entity.WechatKeyword;
import com.lq.entity.WechatRule;
import com.lq.wechat.mode.message.BaseMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Override
    public BaseMessage getByKeyworkdAndWechatInfoId(String keyworkd, WechatInfo wechatInfo) {
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
        wechatRuleVo.setWechatKeywordList(wechatKeywordList);
        return wechatRuleVo;
    }

    @Override
    public BaseDao<WechatRule> getBaseDao() {
        return wechatRuleDao;
    }
}
