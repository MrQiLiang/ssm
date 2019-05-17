package com.lq.cms.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by qi_liang on 2018/4/15.
 */
@Aspect
@Component
public class SysUserServiceAspectj {

    @Pointcut("execution(* com.lq.cms.service.SysUserService.findByLoginNameAndPassword(..))")
    public void perFormEncord(){}


    //前置通知
    @Before(value = "perFormEncord()")
    public void before( JoinPoint joinPoint){
        System.out.println("========切入 start========");
//        for (Object object:joinPoint.getArgs()){
//            System.out.println(object.getClass());
//            System.out.println(object.toString());
//        }
    }

    //后置通知
    @After(value = "perFormEncord()")
    public void after(){
        System.out.println("========切入 end========");
    }

    //后置返回通知
    @AfterReturning(value = "perFormEncord()",returning = "retVal")
    public void afterReturning(JoinPoint joinPoint,Object retVal){


    }


}
