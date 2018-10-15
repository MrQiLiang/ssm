package com.lq.cms.service;

import com.lq.cms.mode.MenusComposite;
import com.lq.cms.vo.SysResourceVo;
import com.lq.code.service.BaseService;
import com.lq.entity.SysResource;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qi_liang on 2018/6/21.
 */
public interface SysResourceService extends BaseService<SysResource> {
    Integer count(SysResourceVo vo);

    List<SysResourceVo> findListpages(SysResourceVo vo);

    List<SysResource> findByParentId(long parenId);
    //通过用户查找相关的菜单
    List<MenusComposite> findMenusListBySysUserId(Long sysUserId, HttpServletRequest request);
    //用户拥有admin权限查询全部菜单
    List<MenusComposite> findAllMenusList(HttpServletRequest request);


}
