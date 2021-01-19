# 简述laravel的生命周期

## 第一步：开始

Laravel 采用了单一入口模式，应用的所有请求入口都是 public/index.php 文件.

### index.php 代码地址

https://github.com/laravel/laravel/blob/master/public/index.php

### 注册类文件自动加载器

Laravel 通过 composer 进行依赖管理，无需开发者手动导入各种类文件，而是由自动加载器自动导入。

### 创建服务器容器

从 bootstrap/app.php 文件中取得 Laravel 应用实例 $app（服务器容器）。

## 第二步：进入 HTTP/Console 内核处理

### 创建 HTTP/Console 内核

传入的请求会被发送给 HTTP 内核或者 console 内核进行处理

## 第三步：加载服务提供容器

在内核引导启动的过程中最重要的动作之一就是载入服务提供者到你的应用，服务提供者负责引导启动框架的全部各种组件。

例如数据库、队列、验证器以及路由组件等。

## 第四步：分配请求

一旦应用完成引导和所有服务提供者都注册完成，Request 将会移交给路由进行分发。

路由将分发请求给一个路由或控制器，同时运行路由指定的中间件。









**[点击返回主页](https://liudandandear.gitee.io)**