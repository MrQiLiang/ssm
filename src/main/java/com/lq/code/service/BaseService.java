package com.lq.code.service;

import com.lq.code.dao.BaseDao;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface BaseService<T> {

    BaseDao<T> getBaseDao();

    T findOne(Long id);

    List<T> findAll();

    Long save(T entity);

    void update(T entity);

    void delete(Long id);

    void batchSave(List<T> entitylist);

    void batchUpdate(List<T> entitylist);

    void batchDelete(List<T> entitylist);

}
