package com.lq.code.interceptor;

import com.lq.cms.emun.StatusTypeEnum;
import com.lq.code.util.CusAccessObjectUtil;
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
 * spring 拦截器
 * @author qi
 */
public class SpringmvcInterceptor implements HandlerInterceptor {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

        SysLog log=new SysLog();
        String ip = CusAccessObjectUtil.getIpAddress(request);
        log.setUserIp(ip);
        log.setUrl(request.getRequestURI());
        log.setCreateTime(new Date());
        log.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
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
