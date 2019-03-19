package com.lq.dao;

import com.lq.cms.vo.SysResourceVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017-11-29.
 */
public interface SysResourceDao extends BaseDao<SysResource> {

     List<SysResource> findByParentId(@Param("parentId") Long parentId);

     List<SysResource> findList(SysResourceVo vo);

     List<SysResourceVo> findListPage(SysResourceVo vo);

     Integer count(SysResourceVo vo);

     List<SysResource> findMenu(Map<String, Object> map);

}
