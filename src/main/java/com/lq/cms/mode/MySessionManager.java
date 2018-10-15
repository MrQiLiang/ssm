package com.lq.cms.mode;

import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

/**
 * Created by qi_liang on 2018/1/26.
 */
public class MySessionManager extends DefaultWebSessionManager {

    public MySessionManager(){
        SimpleCookie cookie = new SimpleCookie("shiroSessionId");
        cookie.setHttpOnly(true);
        this.setSessionIdCookie(cookie);
        this.setSessionIdCookieEnabled(true);
    }

}
