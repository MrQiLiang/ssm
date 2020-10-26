# ssm项目
## ssm 介绍

***一个基于spring mvc+mybatis的框架。页面是采用aceAdmin+easyUI.
使用shiro作为安全框架，做权限控制***

## ssm开发环境

* jdk1.8
* Maven 3
* Mysql 5.6
* tomcat 8
* Redis 

## 技术栈

| 技术           | git地址                                           | 说明                              |
| -------------- | ------------------------------------------------- | :-------------------------------- |
| Spring         |                                                   |                                   |
| spring mvc     |                                                   |                                   |
| Apache Shiro   |                                                   | 安全框架                          |
| Mybatis-plus   | https://gitee.com/baomidou/mybatis-plus           | 数据持久层框架                    |
| spring session | https://github.com/spring-projects/spring-session | 在集群环境下，解决session同步问题 |
| Minio          | https://github.com/minio/minio-java               | 文件服务系统                      |
| hutool         | https://gitee.com/loolly/hutool                   | 国产工具类                        |
| jmockdata      | https://github.com/jsonzou/jmockdata              | 测试工具类                        |
| Durid          | https://github.com/alibaba/druid                  | 数据库连接池                      |
| zxing          | https://github.com/zxing/zxing                    | 二维码生成工具类                  |
| jsoup          |                                                   | 爬虫工具                          |











## ssm 使用说明

+ 菜单目录采用设计模式中的容器模式,理论上是可以实现三级甚至四级的菜单目录（参考代码：com.lq.cms.mode.MenusComposite）.

+ 自定义一个mybatis的xml生成插件(CreateMapperFileUtil)，配合BaseDao一起使用.基本实现单表的CURD操作功能

+ 自定义实体同步数据库表结构插件(com.lq.code.executor.processor.InstantiationTracingBeanPostProcessor)

+ AdminBaseDao,AdminBaseServer,AdminBaseController.三层类结构的继承。可以实现简单模块基本管理功能。

+ 使用spring session整合redis实现在集群中session共享的效果

+ 微信公众号相关开发代码（com.lq.wechat），其中客服消息采用了建造者模式(com.lq.wechat.mode.template)。

  

## 三层架构理念

- 数据库表与mapping.xml一一对应。
- dao层代码密度低，dao层代码尽量通用，以工具类形式使用。便于代码重用
- service层代码密度高 通过组合复用原则使用dao层工具类,实现业务逻辑
- controller层代码密度低 只负责简单的数据接受和转发。以及页面跳转的控制



## 示例

* www.000oo1.com/ssm/cms/
* 默认账号/密码：admin/123



