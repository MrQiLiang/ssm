package com.lq.cms.web.sys;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.cms.service.SysRoleService;
import com.lq.cms.service.SysUserRoleService;
import com.lq.cms.service.SysUserService;
import com.lq.cms.vo.SysUserRoleVo;
import com.lq.cms.vo.SysUserVo;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.BeanUtil;
import com.lq.code.util.FileUtil;
import com.lq.code.util.Md5Util;
import com.lq.code.util.StringUtil;
import com.lq.entity.SysUser;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by qi_liang on 2018/1/25.
 */
@Controller
@RequestMapping("/cms/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);


    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Value("${file.upload}")
    private String FILE_LOAD_PATH;

    @RequiresPermissions("/cms/user/index:SELECT")
    @RequestMapping("/index")
    public ModelAndView  index(ModelAndView modelAndView){

        modelAndView.setViewName("cms/sys/user/index");
        return modelAndView;
    }

    @RequiresPermissions("/cms/user/index:SELECT")
    @RequestMapping("/list")
    @ResponseBody
    public Object list(SysUserVo vo){
        Map<String,Object> map=new HashMap();
        map.put("total",sysUserService.count(vo));
        map.put("rows",sysUserService.findListPage(vo));
        return map;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(ModelAndView modelAndView,Long id){
        SysUser sysUser=sysUserService.findOne(id);
        List<SysUserRoleVo> sysUserRoleVoList=sysRoleService.findAllRoleVo(id);
        modelAndView.addObject("sysUser",sysUser);
        modelAndView.addObject("roleList",sysUserRoleVoList);
        modelAndView.setViewName("cms/sys/user/edit");
        return modelAndView;
    }


    @RequiresPermissions("/cms/user/index:INSERT")
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(SysUserVo vo,@RequestParam(value = "file",required = false) MultipartFile file){
        Date nowTime =new Date();
        AjaxResult ajaxResult = new AjaxResult();
        SysUser sysUser = new SysUser();
        BeanUtil.copyNotNull(vo,sysUser);
        sysUser.setCreateTime(nowTime);
        sysUser.setPassword(Md5Util.getMd5(sysUser.getPassword()));
        sysUser.setUpdateTime(nowTime);
        String uploadFileName =upLoadFile(file);
        sysUser.setImgUrl(uploadFileName);
        sysUser.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
        sysUserService.save(sysUser);
        sysUserRoleService.updateUserRole(sysUser.getId(),vo.getRoleList());
        return ajaxResult;
    }

    @RequiresPermissions("/cms/user/index:UPDATE")
    @ResponseBody
    @RequestMapping("/update")
    public Object update(SysUserVo vo,@RequestParam(value = "file",required = false) MultipartFile file){
            Date nowTime = new Date();
            AjaxResult ajaxResult = new AjaxResult();
            if (vo!=null&&vo.getId()!=null){
                SysUser sysUser = sysUserService.findOne(vo.getId());
                BeanUtil.copyNotNull(sysUser,vo);
                sysUser.setUpdateTime(nowTime);
                String uploadFileName =upLoadFile(file);
                sysUser.setImgUrl(uploadFileName);
                sysUserService.update(sysUser);
                sysUserRoleService.updateUserRole(sysUser.getId(),vo.getRoleList());
            }else {
                ajaxResult.setSuccess(false);
                ajaxResult.setMsg("更新失败");
            }

        return  ajaxResult;
    }

    @RequiresPermissions("/cms/user/index:DELETE")
    @RequestMapping("/delete")
    @ResponseBody
    public Object delte(SysUser sysUser){
        AjaxResult ajaxResult=new AjaxResult();
        if (sysUser!=null&&sysUser.getId()!=null){
            sysUserService.delete(sysUser.getId());
        }

        return ajaxResult;
    }

    //内部方法 ，上传文件，并返回文件路径
    private String upLoadFile(MultipartFile multipartFile){
        String newFileName = null;
        if (multipartFile!=null && multipartFile.getSize()>0){
            UUID uuid = UUID.randomUUID();
            String fileType = FileUtil.fileFormat(multipartFile.getOriginalFilename());
            newFileName = "user/"+uuid.toString()+"."+fileType;
            File newFile = new File(FILE_LOAD_PATH +newFileName);

            if (!newFile.exists()){
                newFile.mkdirs();
            }
            try {
                multipartFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return newFileName;
    }


    @RequestMapping("/updatePass")
    @ResponseBody
    public Object updatePass(String oldPass,String newPass){
        AjaxResult ajaxResult = new AjaxResult();
        Subject subject= SecurityUtils.getSubject();
        SysUser sysUser= (SysUser) subject.getPrincipal();
        System.out.println(StringUtil.isNotNull(oldPass)&&StringUtil.isNotNull(newPass));
        if (StringUtil.isNotNull(oldPass)&&StringUtil.isNotNull(newPass)){
            String md5Pass = Md5Util.getMd5(oldPass);
            if (md5Pass.equals(sysUser.getPassword())){
                sysUser.setPassword(Md5Util.getMd5(newPass));
                sysUser.setUpdateTime(new Date());
                sysUserService.update(sysUser);
            }else {
                ajaxResult.setSuccess(false);
                ajaxResult.setMsg("旧密码不正确!,请重新输入.");
            }
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("参数为空，请检查");
        }



        return ajaxResult;
    }


}
