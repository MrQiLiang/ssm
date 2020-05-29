package com.lq.cms.service;

import com.lq.cms.mode.MenusComposite;
import com.lq.cms.vo.SysResourceVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysResource;
import java.util.List;

/**
 *  菜单事务类
 *  @author qi
 */
public interface SysResourceService extends BaseService<SysResource> {
    /**
     *  统计
     * @param vo
     * @return
     */
    Integer count(SysResourceVo vo);

    /**
     *  带分页功能查询
     * @param vo
     * @return
     */
    List<SysResourceVo> findListPages(SysResourceVo vo);

    /**
     * 通过父级菜单查找子菜单集合
     * @param parenId
     * @return
     */
    List<SysResource> findByParentId(long parenId);

    /**
     * 通过用户查找相关的菜单
     * @param sysUserId
     * @param contextPath
     * @return
     */
    List<MenusComposite> findMenusListBySysUserId(Long sysUserId,String contextPath);

    /**
     * 用户拥有admin权限查询全部菜单
     * @param contextPath
     * @return
     */
    List<MenusComposite> findAllMenusList(String contextPath);


}
