package com.lq.wechat.mode;

/**
 * @Author: qi
 * @Description: token对象
 * @Date: Create in 9:28 AM 2019/3/15
 */
public class AccessToken {

    /**
     * 微信公众号令牌
     */
    private String access_token;
    /**
     * 令牌过期时间
     */
    private Long expires_in;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误提示
     */
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
