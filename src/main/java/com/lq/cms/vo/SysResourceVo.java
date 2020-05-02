package com.lq.cms.vo;

import com.lq.code.util.DateUtil;

import java.util.Date;

/**
 * 菜单视图
 * @author qi
 */
public class SysResourceVo  extends BasePageVo{

    private Long id;

    private String urlPath;

    private Integer sort;

    private Date updateTime;

    private Date createTime;

    private Long userId;

    private String userName;

    private String createTimeStr;

    private String updateTimeStr;

    private Integer status;
    /**
     * 菜单名称
     */
    private String menuName;

    private Long parentId;
    /**
     * 上级菜单名称
     */

    private String parentMenuName;
    /**
     * 菜单图标
     */
    private String menuIco;

    public Long getId() {
        return id;
    }

    public SysResourceVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public SysResourceVo setUrlPath(String urlPath) {
        this.urlPath = urlPath;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public SysResourceVo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysResourceVo setUpdateTime(Date updateTime) {
        this.updateTimeStr= DateUtil.getDateToStr(updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public SysResourceVo setCreateTime(Date createTime) {
        this.createTimeStr=DateUtil.getDateToStr(createTime);
        this.createTime = createTime;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SysResourceVo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SysResourceVo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public SysResourceVo setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public SysResourceVo setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMenuName() {
        return menuName;
    }

    public SysResourceVo setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public String getMenuIco() {
        return menuIco;
    }

    public void setMenuIco(String menuIco) {
        this.menuIco = menuIco;
    }
}
