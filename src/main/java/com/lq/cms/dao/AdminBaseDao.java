package com.lq.cms.dao;

import com.lq.cms.vo.AdminBaseVo;
import com.lq.code.dao.BaseDao;

import java.util.List;

public interface AdminBaseDao<T> extends BaseDao {

    List<AdminBaseVo> findLisatPage(AdminBaseVo vo);

    int count(AdminBaseVo vo);

}
