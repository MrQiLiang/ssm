package com.lq.code.util.os.mode;

/**
 * Created by qi_liang on 2018/6/10.
 */
public class OsInfo {

    //操作系统名称
    private String osName;
    //操作系统版本号
    private String osVersion;
    //操作系统架构
    private String arch;

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }
}
