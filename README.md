# ssm项目
## ssm 介绍
```java
一个基于spring mvc+mybatis的框架。页面是采用aceAdmin+easyUI.
使用shiro作为安全框架，做权限控制
```
## ssm开发环境
```java
1. jdk 1.8
2. maven 3
3. mysql 5.6
4. redis
5. tomcat 8
```
## ssm 使用说明
```java
1. 菜单目录采用设计模式中的容器模式,理论上是可以实现三级甚至四级的菜单目录（参考代码：com.lq.cms.mode.MenusComposite）.
2. 自定义一个mybatis的xml生成插件(CreateMapperFileUtil)，配合BaseDao一起使用.基本实现单表的CURD操作功能
3. 自定义实体同步数据库表结构插件(com.lq.code.executor.processor.InstantiationTracingBeanPostProcessor)
4. AdminBaseDao,AdminBaseServer,AdminBaseController.三层类结构的继承。可以实现简单模块基本管理功能。
5. 使用spring session整合redis实现在集群中session共享的效果
6. 微信公众号相关开发代码（com.lq.wechat），其中客服消息采用了建造者模式(com.lq.wechat.mode.template)。
```
## 三层架构理念：
```java
1. 数据库表与mapping.xml一一对应。
2. dao层代码密度低，dao层代码尽量通用，以工具类形式使用。便于代码重用
3. service层代码密度高 通过组合复用原则使用dao层工具类,实现业务逻辑
4. controller层代码密度低 只负责简单的数据接受和转发。以及页面跳转的控制

```
## 示例
```java
1. 项目案例：http://106.12.122.216:8080/ssm/cms/
2. 默认账号/密码：admin/123
```