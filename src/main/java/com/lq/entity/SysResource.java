package com.lq.entity;

import com.lq.code.entity.IdEntity;

import java.util.Date;

/** 资源表
 * Created by qi on 2017-11-29.
 */
public class SysResource extends IdEntity {

    //跳转路径
    private  String urlPath;
    //序号
    private Integer sort;
    //上级目录id;
    private Long parentId;
    //创建该目录用户id
    private Long userId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //目录名称
    private String menuName;
    //目录logo
    private String menuIco;

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIco() {
        return menuIco;
    }

    public void setMenuIco(String menuIco) {
        this.menuIco = menuIco;
    }
}
