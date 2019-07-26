# ssm

ssm 介绍

一个基于sping mvc+mybatis的框架。页面是采用aceAdmin+easyui.
使用shiro作为安全框架，做权限控制

ssm 软件架构
软件架构说明


ssm 安装教程
1. jdk1.8
2. maven3
3. mysql5.6
4. redis

ssm 使用说明
1. 菜单目录采用设计模式中的容器模式,理论上是可以实现三级甚至四级的菜单目录.
2. 自定义一个mybatis的xml生成插件(com.lq.code.util.mybatisPlus.CreateMapperFileUtil)，配合BaseDao一起使用.基本实现单表的操作功能
3. 自定义实体同步数据库表结构插件(com.lq.code.executor.processor.InstantiationTracingBeanPostProcessor)
4. AdminBaseDao,AdminBaseServer,AdminBaseController.三层类结构的继承。可以实现简单模块基本管理功能。

三层架构理念：
1. 数据库表与mapping.xml一一对应。
2. dao层代码密度低，dao层代码尽量通用，以工具类形式使用。便于代码重用
3. service层代码密度高 通过组合复用原则使用dao层工具类,实现业务逻辑
4. controller层代码密度低 只负责简单的数据接受和转发。以及页面跳转的控制

1. 项目案例：http://106.12.122.216:8081/ssm/cms/
2. 默认账号/密码：admin/123
