package com.lq.cms.dao;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.dao.BaseDao;

import java.util.List;

public interface AdminBaseDao<T,V extends AdminBaseVo> extends BaseDao<T> {

    List<V> findListPage(V vo);

    int count(V vo);

}
