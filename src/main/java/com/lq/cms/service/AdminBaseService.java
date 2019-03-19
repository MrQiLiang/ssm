package com.lq.cms.service;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.service.BaseService;

import java.util.List;

public interface AdminBaseService<T,V extends AdminBaseVo> extends BaseService<T>{

    List<V> findListPage(V vo);

    int count(V vo);

    T save(V vo)throws IllegalAccessException, InstantiationException;

    T update(V vo);
}
