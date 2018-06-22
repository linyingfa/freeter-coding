 **飞特后台管理系统是接私活利器，企业级快速开发框架**
 
**项目说明** 

- 采用SpringBoot、MyBatis、Shiro、mybaits-plus黄金搭档。
- 有单独的后台，还有单独的接口框架，可以实现前后端分离协作开发，还有火爆的商场功能模块
- 提供了超级代码生成器，可以生成验证注解，swagger-ui注解，多表分页查询sql,只需编写30%左右代码，其余的代码交给系统自动生成，可快速完成开发任务
- 支持MySQL、Oracle、SQL Server、PostgreSQL等主流数据库
<br>

**具有如下特点** 
- 火爆的商场模块，后续会加入更多的商城模块
- 超级代码生成器，可直接生成到IDE中，eclipse和ij都可以
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的部门管理及数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，支持白名单过滤,彻底杜绝XSS攻击
- 支持分布式部署，session存储在redis中
- 友好的代码结构及注释，便于阅读及二次开发
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 页面交互使用layui,vue.js，极大的提高了开发效率
- 引入swagger文档支持，方便编写API接口文档

<br>

 **项目结构** 

freeter-coding 此项目会持续更新

|--freeter-admin 后台管理 <br>
|--freeter-api 移动端接口<br>
|--freeter-common 公共模块<br>
|--freeter-generator 代码生成<br>

<br> 



<br>

 **技术选型：** 
- 核心框架：Spring Boot
- 安全框架：Apache Shiro
- 视图框架：Spring MVC
- 持久层框架：MyBatis
- 定时器：Quartz 2.3
- 数据库连接池：Druid
- 日志管理：logback
- 页面交互：layui
- 下拉框：bootstrap-select
- 文件上传：Bootstrap File Input
- 热部署 jrebel
- 验证框架 hibernate-validator
- mybatis加强工具 mybatis-plus
- 通用工具类 hutool
<br>

 **软件需求** 
- JDK1.8
- MySQL5.5+
- Tomcat8+
- Maven3.0+

<br>

 **本地部署**
- 通过git下载源码
- 创建数据库renren_security，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据【按需导入表结构及数据】
- 修改application-dev.yml文件，更新MySQL账号和密码
- 在renren-security目录下，执行mvn clean install
<br>

- Eclipse、IDEA运行AdminApplication.java，则可启动项目【renren-admin】
- renren-admin访问路径：http://localhost:8080/renren-admin
- swagger文档路径：http://localhost:8080/renren-admin/swagger/index.html
- 账号密码：admin/admin

<br>

- Eclipse、IDEA运行ApiApplication.java，则可启动项目【renren-api】
- renren-api访问路径：http://localhost:8081/renren-api/swagger-ui.html

<br>

- Eclipse、IDEA运行GeneratorApplication.java，则可启动项目【renren-generator】
- renren-generator访问路径：http://localhost:8082/renren-generator


<br>

 **分布式部署**
- 分布式部署，需要安装redis，并配置config.properties里的redis信息
- 需要配置【renren.redis.open=true】，表示开启redis缓存
- 需要配置【renren.shiro.redis=true】，表示把shiro session存到redis里

<br>

 **项目演示**
- 演示地址：http://demo.open.renren.io/renren-security
- 账号密码：admin/admin

<br>

**如何交流、反馈、参与贡献？** 
- 开发文档：http://www.renren.io/guide/security
- 官方社区：http://www.renren.io/community
- gitee仓库：https://gitee.com/renrenio/renren-security
- github仓库：https://github.com/renrenio/renren-security
- [人人开源](http://www.renren.io)：http://www.renren.io   
- 官方QQ群：324780204、145799952
- 如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持
- 技术讨论、二次开发等咨询、问题和建议，请移步到官方社区，我会在第一时间进行解答和回复！
- 微信扫码并关注【人人开源】，获得项目最新动态及更新提醒<br>
![输入图片说明](http://cdn.renren.io/47c26201804031918312618.jpg "在这里输入图片标题")
<br>
<br>

**接口文档效果图：** 
![输入图片说明](http://cdn.renren.io/img/c8dae596146248d8b4d0639738c2932b "在这里输入图片标题")

<br>

**Layui主题风格：**
![输入图片说明](http://cdn.renren.io/img/1013aa91fe8542b7b05d82bc9444433a "在这里输入图片标题")

<br>

**AdminLTE主题风格：**
![输入图片说明](http://cdn.renren.io/img/f9762bc6574545ce908e271995efcf1c "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/a1b8bf1ea3db4844a8652a9cf84048cc "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/e542060605f94b3ebec699b0afffc22d "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/c94be5b4bf0d4387b18e119c91b1a986 "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/ae8c683a01c74d8dbc52d62547efda31 "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/ca38bcf3717c427d82dd67d86b744e18 "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/4862ec46a9ad469b90c30788c4707e35 "在这里输入图片标题")
![输入图片说明](http://cdn.renren.io/img/5d8e7243d30a4421b90f15394b6d1ccd "在这里输入图片标题")

<br>

![捐赠](http://cdn.renren.io/donate.jpg "捐赠") 