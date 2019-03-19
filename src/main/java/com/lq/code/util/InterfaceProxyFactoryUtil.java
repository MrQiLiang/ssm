package com.lq.code.util;

import com.lq.dao.SysUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 为接口提供动态代理方式，可以尝试模拟 JPA
 * Created by qi_liang on 2018/4/23.
 */
public class InterfaceProxyFactoryUtil implements InvocationHandler {


    public static <T> T newMapperProxy(Class<T> mammperInterface){
        ClassLoader classLoader = mammperInterface.getClassLoader();
        Class<?> [] interfaces = new Class[]{mammperInterface};
        InterfaceProxyFactoryUtil proxy = new InterfaceProxyFactoryUtil();
        return (T) Proxy.newProxyInstance(classLoader,interfaces,proxy);
    }

    public static void main(String[] args) {
        SysUserDao sysUserDao = InterfaceProxyFactoryUtil.newMapperProxy(SysUserDao.class);
        sysUserDao.findByEmail("565391376");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=======接口调用方法开始======");
        //解析方法生成业务逻辑  start
        System.out.println("method toGenericString:"+method.toGenericString());
        System.out.println("method name:"+method.getName());
        System.out.println("method args:"+args[0]);
        //解析方法生成业务逻辑  end
        System.out.println("=======接口调用方法结束=======");
        return null;
    }
}
