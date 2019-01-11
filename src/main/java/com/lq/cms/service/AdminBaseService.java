package com.lq.cms.service;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.service.BaseService;

import java.util.List;

public interface AdminBaseService<T> extends BaseService<T>{

    List<AdminBaseVo> findListPage(AdminBaseVo vo);

    int count(AdminBaseVo vo);

    T save(AdminBaseVo vo)throws IllegalAccessException, InstantiationException;

    T update(AdminBaseVo vo);
}
