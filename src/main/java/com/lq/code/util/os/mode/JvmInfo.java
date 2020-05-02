package com.lq.code.util.os.mode;

/**
 * jvm 详情
 * @author qi
 *
 */
public class JvmInfo {
    /**
     * 版本号
     */
    private String version;
    /**
     * 总内存
     */
    private Long totalMemory;
    /**
     * 可以使用处理器个数
     */
    private Integer cupNum;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Integer getCupNum() {
        return cupNum;
    }

    public void setCupNum(Integer cupNum) {
        this.cupNum = cupNum;
    }
}
