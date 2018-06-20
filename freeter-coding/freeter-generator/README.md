**项目介绍** 
- 飞特后台管理系统的超级代码生成器，可直接生成四种实体类，controller、service、dao、xml代码到eclipse或ide，减少70%以上的开发任务
- 目前只支持MySQL、下个版本支持oracle。
<br>

**同行特点** 
- 实体类默认引入swagger-ui 的注解。
- 实体类默认引入日期类格式化 的注解。
- 实体类默认引入hibernate-validator的注解
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 友好的代码结构及注释，便于阅读及二次开发

<br>

**实体类设计思想** 
- entity 是数据库层do，通用操作实体类（普通增删改查）

- model  接收传参的实体类  取自ModelAndView 的model名称
     	   实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
- vo     返回的视图类  主要是手机端接口返回的实体类 
	          （主要作用去除一些不必要的字段） 

- view  后端返回视图实体辅助类   
                 （通常后端关联的表或者自定义的字段需要返回使用）
<br> 

**项目结构** 

<br>

 **技术选型：** 
- 核心框架：Spring Boot 1.5
- 安全框架：Apache Shiro 1.3
- 视图框架：Spring MVC 4.3
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x

<br>

 **软件需求** 
- JDK1.8
- MySQL5+
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
- renren-admin访问路径：http://localhost:8082/freeter-generator
 
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