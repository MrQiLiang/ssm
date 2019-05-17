package com.lq.cms.service.impl;

import com.lq.cms.dao.AdminBaseDao;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.AdminBaseService;
import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.dao.BaseDao;
import com.lq.code.service.impl.BaseServiceImpl;
import com.lq.code.util.BeanUtil;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

public abstract class AdminBaseServiceImpl<T,V extends AdminBaseVo> extends BaseServiceImpl<T> implements AdminBaseService<T,V>{

    abstract AdminBaseDao<T,V> getAdminBaseDao();

    @Override
    public List<V> findListPage(V vo) {
        return this.getAdminBaseDao().findListPage(vo);
    }

    @Override
    public int count(V vo) {
        return this.getAdminBaseDao().count(vo);
    }

    @Override
    public T save(AdminBaseVo vo) throws IllegalAccessException, InstantiationException {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        T t = clazz.newInstance();
        vo.setCreateTime(new Date());
        vo.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        BeanUtil.copyNotNull(t,vo);
        getBaseDao().save(t);
        return t;
    }

    @Override
    public T update(AdminBaseVo vo) {
        T t = (T) getBaseDao().findOne(vo.getId());
        BeanUtil.copyNotNull(t,vo);
        getBaseDao().update(t);
        return t;
    }

    @Override
    public BaseDao<T> getBaseDao() {
        return getAdminBaseDao();
    }


}
