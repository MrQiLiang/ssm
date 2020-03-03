package com.lq.cms.dao;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.dao.BaseDao;

import java.util.List;

/**
 * @author qi
 * @param <T> 实体类
 * @param <V> 视图实体
 */
public interface AdminBaseDao<T,V extends AdminBaseVo> extends BaseDao<T> {

    /**
     * 带参数分页查询
     * @param vo
     * @return
     */
    List<V> findListPage(V vo);

    /**
     * 参数统计
     * @param vo
     * @return
     */
    int count(V vo);

}
