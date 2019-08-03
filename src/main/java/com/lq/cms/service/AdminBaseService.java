package com.lq.cms.service;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.service.BaseService;

import java.util.List;

public interface AdminBaseService<T,V extends AdminBaseVo> extends BaseService<T>{

    /**
     *   分页查询
     * @param vo
     * @return
     */
    List<V> findListPage(V vo);

    /**
     * 统计数据条数
     * @param vo
     * @return
     */
    int count(V vo);

    /**
     *  保存
     * @param vo
     * @return
     */
    T save(V vo);

    /**
     *  删除
     * @param vo
     * @return
     */
    T update(V vo);
}
