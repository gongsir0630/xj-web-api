# java-app-template

## 介绍

基于 [Spring Boot] 搭建的 Java 后端基础开发环境, 整合了以下常用技术栈:

* fastjson -> 阿里巴巴 json 处理框架
  
* druid/MySQL -> 基于 MySQL 数据库, 使用阿里巴巴的 Druid 连接池
  
* [MyBatis-Plus](https://baomidou.com/) -> MyBatis 增强
  
* Shiro/JWT -> 认证鉴权
  
* Swagger -> 接口文档
  
* 七牛云 -> 对象存储
  
* [Hutool](https://www.hutool.cn/) -> Java 工具类
  
* Lombok -> 简化开发
  
* 多环境配置, 指定环境动态切换配置文件

## 使用

* 直接 fork 项目二次开发即可

* 打包时通过 `-P` 参数指定打包环境: `mvn clean package -Ppro -Dmaven.test.skip=true`