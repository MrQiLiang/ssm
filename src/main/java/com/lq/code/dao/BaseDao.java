package com.lq.code.dao;

import java.util.List;

/**
 * Created by qi on 2017/7/16.
 */
public interface BaseDao<T> {

    /**
     *  保存对象，返回id
     * @param entity
     * @return
     */
      Long save(T entity);

    /**
     * 更新对象
     * @param entity
     * @return
     */
     void update(T entity);

    /**
     *  通过id 查找单个对象
     * @param id
     * @return
     */
     T findOne(Long id);

    /**
     *  查询全部数据
     * @return
     */
     List<T> findAll();


    /**
     *  删除一条数据
     * @param id
     */
     void delete(Long id);

    /**
     *  批量保存数据
     * @param entitylist
     */
    void batchSave(List<T> entitylist);

    /**
     *  批量更新数据
     * @param entitylist
     */
     void batchUpdate(List<T> entitylist);

    /**
     *  批量删除数据
     * @param entitylist
     */
    void batchDelete(List<T> entitylist);


}
