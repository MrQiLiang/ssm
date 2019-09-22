package com.lq.code.service;

import com.lq.code.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface BaseService<T> {

    BaseDao<T> getBaseDao();

    default T findOne(Long id){
       return getBaseDao().findOne(id);
    }

    default List<T> findAll(){
        return getBaseDao().findAll();
    }

    default Long save(T entity){
        return getBaseDao().save(entity);
    }

    default void update(T entity){
        getBaseDao().update(entity);
    }

    default void delete(Long id){
        getBaseDao().delete(id);
    }

    @Transactional
    default void batchSave(List<T> entitylist){
        getBaseDao().batchSave(entitylist);
    }

    @Transactional
    default void batchUpdate(List<T> entitylist){
        getBaseDao().batchSave(entitylist);
    }

    @Transactional
    default void batchDelete(List<T> entitylist){
        getBaseDao().batchDelete(entitylist);
    }

}
