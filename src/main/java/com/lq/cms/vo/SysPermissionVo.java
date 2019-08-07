package com.lq.cms.vo;

import com.lq.code.util.DateUtil;
import com.lq.code.util.StringUtil;

import java.util.Date;

/**
 * @Author: qi
 * @Description:
 * @Date: Create in 11:27 PM 2019/7/22
 */
public class SysPermissionVo extends AdminBaseVo {

    /**
     * 关联资源ID
     */
    private Long sysResourceId;
    /**
     * 关联资源名称
     */
    private String sysResourceName;
    /**
     * 权限名称
     */
    private String name;
    /**
     *  权限类型
     */
    private String permissionType;
    /**
     *  权限键值
     */
    private String permissionKey;
    /**
     * 创建时间（字符串）
     */
    private String createTimeStr;
    /**
     * 创建用户ID
     */
    private Long createUserId;
    /**
     * 创建用户名称
     */
    private String createUserName;
    /**
     * 更新时间（字符串）
     */
    private String updateTimeStr;
    /**
     * 更新用户ID
     */
    private Long updateUserId;
    /**
     * 更新用户名称
     */
    private String updateUserName;

    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }

    public String getSysResourceName() {
        return sysResourceName;
    }

    public void setSysResourceName(String sysResourceName) {
        this.sysResourceName = sysResourceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getCreateTimeStr() {
        if (StringUtil.isNotNull(createTimeStr)){
            return createTimeStr;
        }else{
            return DateUtil.getDateToStr(getCreateTime());
        }

    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateTimeStr() {
        if (StringUtil.isNotNull(updateTimeStr)){
            return updateTimeStr;
        }else{
            return DateUtil.getDateToStr(getUpdateTime());
        }
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
}
