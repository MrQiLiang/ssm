package com.lq.cms.vo;

import com.lq.code.util.DateUtil;

import java.util.Date;

/**
 * 角色视图
 * @author qi
 * Created by qi_liang on 2018/2/1.
 */
public class SysRoleVo extends BasePageVo{

    private Long id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private String createTimeStr;

    private String updateTimeStr;

    public Long getId() {
        return id;
    }

    public SysRoleVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public SysRoleVo setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysRoleVo setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeStr= DateUtil.getDateToStr(createTime);
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysRoleVo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        this.updateTimeStr=DateUtil.getDateToStr(updateTime);
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public SysRoleVo setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public SysRoleVo setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
        return this;
    }
}
