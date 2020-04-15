package com.lq.code.service.impl;

import com.lq.code.dao.BaseDao;
import com.lq.code.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qi
 * Created by qi_liang on 2018/6/21.
 *  采用jdk8 默认方法，所以该实现类废弃
 */
@Deprecated
public abstract  class BaseServiceImpl<T> implements BaseService<T>{
    @Override
    public abstract BaseDao<T> getBaseDao();

    @Override
    public T findOne(Long id) {
        return getBaseDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(T entity) {
        return getBaseDao().save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T entity) {

        getBaseDao().update(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {

        getBaseDao().delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchSave(List<T> entityList) {

        getBaseDao().batchSave(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchUpdate(List<T> entityList) {

        getBaseDao().batchUpdate(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDelete(List<T> entityList) {

        getBaseDao().batchDelete(entityList);
    }
}
