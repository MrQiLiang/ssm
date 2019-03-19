package com.lq.code.interceptor;

import com.lq.dao.SysLogDao;
import com.lq.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by qi on 2017/7/27.
 */
public class SpringmvcInterceptor implements HandlerInterceptor {

    @Autowired
    private SysLogDao sysLogDao;

    @Transactional
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

        SysLog log=new SysLog();
        log.setUserIp(request.getRemoteAddr());
        log.setUrl(request.getRequestURI());
        log.setCreateTime(new Date());
        sysLogDao.save(log);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
