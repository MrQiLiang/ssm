package com.lq.dao;

import com.lq.cms.vo.SysResourceVo;
import com.lq.code.dao.BaseDao;
import com.lq.entity.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by qi on 2017-11-29.
 * @author qi
 * 菜单资源类
 */
public interface SysResourceDao extends BaseDao<SysResource> {
     /**
      * 通过父级菜单ID查找下级菜单集合
      * @param parentId（父级菜单ID）
      * @return
      */
     List<SysResource> findByParentId(@Param("parentId") Long parentId);

     /**
      *  参数查询
      * @param vo
      * @return
      */
     List<SysResource> findList(SysResourceVo vo);

     /**
      * 参数查询实体类
      * @param vo
      * @return
      */
     List<SysResourceVo> findListPage(SysResourceVo vo);

     /**
      * 参数统计
      * @param vo
      * @return
      */
     Integer count(SysResourceVo vo);

     /**
      *
      * @param map
      * @return
      */
     List<SysResource> findMenu(Map<String, Object> map);

}
