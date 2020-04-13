package com.lq.code.service;

import com.lq.code.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface BaseService<T> {

    /**
     * 注入 baseDao
     * @return
     */
    BaseDao<T>  getBaseDao();

    /**
     * 通过ID查找数据
     * @param id
     * @return
     */
    default T findOne(Long id){
       return getBaseDao().findOne(id);
    }

    /**
     * 查询全部
     * @return
     */
    default List<T> findAll(){
        return getBaseDao().findAll();
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    default Long save(T entity){
        return getBaseDao().save(entity);
    }

    /**
     * 更新
     * @param entity
     */
    default void update(T entity){
        getBaseDao().update(entity);
    }

    /**
     * 删除
     * @param id
     */
    default void delete(Long id){
        getBaseDao().delete(id);
    }

    /**
     * 批量保存
     * @param entityList
     */
    @Transactional(rollbackFor = Exception.class)
    default void batchSave(List<T> entityList){
        getBaseDao().batchSave(entityList);
    }

    /**
     * 批量更新
     * @param entityList
     */
    @Transactional(rollbackFor = Exception.class)
    default void batchUpdate(List<T> entityList){
        getBaseDao().batchSave(entityList);
    }

    /**
     * 批量删除
     * @param entityList
     */
    @Transactional(rollbackFor = Exception.class)
    default void batchDelete(List<T> entityList){
        getBaseDao().batchDelete(entityList);
    }

}
