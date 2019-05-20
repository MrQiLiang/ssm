package com.lq.entity;

import com.lq.code.annotation.Length;
import com.lq.code.entity.IdEntity;

/** 权限表
 * Created by qi on 2017-11-29.
 */
public class SysPermission extends IdEntity{

    /**
     * 权限名称
     */

    @Length(value = 80)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
