package com.lq.cms.vo;

import com.lq.code.util.jdbc.mode.DbInfo;
import com.lq.code.util.os.mode.JvmInfo;
import com.lq.code.util.os.mode.OsInfo;

/**
 *
 * 系统信息视图类
 * @author qi
 */
public class SysInfoVo {

    /**
     * 服务器ip
     */
    private String sysIp;
    /**
     * 客服端ip
     */
    private String userIP;
    /**
     * 操作系统信息
     */
    private OsInfo osInfo;
    /**
     * 数据库产品信息
     */
    private DbInfo dbInfo;
    /**
     * 服务器版本信息
     */
    private String serverInfo;
    /**
     * jvm信息
     */
    private JvmInfo jvmInfo;

    public String getSysIp() {
        return sysIp;
    }

    public void setSysIp(String sysIp) {
        this.sysIp = sysIp;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }



    public OsInfo getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(OsInfo osInfo) {
        this.osInfo = osInfo;
    }

    public DbInfo getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(DbInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }

    public JvmInfo getJvmInfo() {
        return jvmInfo;
    }

    public void setJvmInfo(JvmInfo jvmInfo) {
        this.jvmInfo = jvmInfo;
    }
}
