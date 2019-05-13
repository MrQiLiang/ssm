package com.lq.cms.service.impl;

import com.lq.cms.service.WechatInfoService;
import com.lq.cms.vo.WechatInfoVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.dao.WechatInfoDao;
import com.lq.entity.WechatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
@Service
public class WechatInfoServiceImpl extends BaseServiceImpl<WechatInfo> implements WechatInfoService {

    @Autowired
    private WechatInfoDao wechatInfoDao;

    @Override
    public BaseDao<WechatInfo> getBaseDao() {
        return wechatInfoDao;
    }

    @Override
    public Integer count(WechatInfoVo vo) {
        return wechatInfoDao.count(vo);
    }

    @Override
    public List<WechatInfoVo> findListPage(WechatInfoVo vo) {
        return wechatInfoDao.findListPage(vo);
    }

    @Override
    public WechatInfo getByOpenId(String wechatOpenId) {

        return wechatInfoDao.getByWechatOpenId(wechatOpenId);
    }

    @Override
    public WechatInfo getByWechatName(String wechatName) {

        return wechatInfoDao.getByWechatName(wechatName);
    }
}
