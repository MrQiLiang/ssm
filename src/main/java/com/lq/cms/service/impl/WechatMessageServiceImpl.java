package com.lq.cms.service.impl;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.service.WechatMessageService;
import com.lq.cms.vo.WechatMessageVo;
import com.lq.code.util.BeanUtil;
import com.lq.dao.WechatMessageDao;
import com.lq.entity.WechatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WechatMessageServiceImpl extends AdminBaseServiceImpl<WechatMessage,WechatMessageVo> implements WechatMessageService {

    @Autowired
    private WechatMessageDao wechatMessageDao;


    @Override
    AdminBaseDao getAdminBaseDao() {

        return wechatMessageDao;
    }

    @Override
    public List<WechatMessageVo> findAllWechatMessageVo() {
        List<WechatMessageVo> wechatMessageVoList = new ArrayList<>();
        List<WechatMessage> wechatMessageList = wechatMessageDao.findAll();
        wechatMessageList.forEach(wechatMessage -> {
            WechatMessageVo wechatMessageVo = new WechatMessageVo();
            BeanUtil.copyNotNull(wechatMessageVo,wechatMessage);
            wechatMessageVoList.add(wechatMessageVo);
        });

        return wechatMessageVoList;
    }
}
