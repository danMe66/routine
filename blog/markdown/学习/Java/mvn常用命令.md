# mvn常用命令

## 1：创建maven普通的java项目

```shell
mvn archetype:create
-DgroupId=packageName
-DartifactId=projectName
```

## 2：创建maven的web项目

```shell
mvn archetype:create
-DgroupId=packageName
-DartifactId=webappName
-DarchetypeArtifactId=maven-archetype-webapp
```

## 3：其他常用命令

```shell
mvn package ：打包
mvn site ： 产生site
mvn test ： 运行测试
mvn compile ： 编译
mvn test-compile ： 编译测试代码
mvn archetype:generate ： 反向生成项目的骨架
mvn jar ： 生成jar包
mvn install ： 本地安装
mvn clean ： 清除编译后的项目文件
mvn eclipse:eclipse ： 生成eclipse项目
mvn idea:idea ： 生成idea项目
mvn -Dtest package ： 只打包不测试
mvn test -skipping comiple ： 只测试不编译
mvn dependency:list ： 查看当前项目已被解析的依赖
mvn deploy ： 上传到私服
mvn source:jar ： 源码打包
mvn -e ： 显示详细错误信息
mvn validate ： 验证工程是否正确
mvn jetty:run ： 运行项目于jetty上
```

