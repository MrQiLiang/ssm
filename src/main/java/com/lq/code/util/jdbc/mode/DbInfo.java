package com.lq.code.util.jdbc.mode;

/**
 * 数据库详情
 * Created by qi_liang on 2018/6/10.
 */
public class DbInfo {
    /**
     * 数据库名称
     */
    private String name;

    /**
     * 数据库版本号
     */
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
