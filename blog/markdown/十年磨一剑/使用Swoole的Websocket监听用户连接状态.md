# 使用Swoole的Websocket监听用户连接状态              

## 什么是 Swoole？

> Swoole：PHP 协成框架
>
> Swoole  使 PHP 开发人员可以编写高性能的高并发的 TCP、UDP、Unix Socket、HTTP、 WebSocket 等服务，让 PHP不在局限于 Web 领域。
>
> Swoole4 协程的成熟将 PHP 带入了前所未有的时期， 为性能的提升提供了独一无二的可能性。Swoole 可以广泛应用于互联网、移动通信、云计算、 网络游戏、物联网（IOT）、车联网、智能家居等领域。使用 PHP + Swoole 可以使企业 IT 研发团队的效率大大提升，更加专注于开发创新产品。
>
> ​                                                                                                                        — 摘自 Swoole 官网

## Websocket 服务

## 代码

```php
<?php
$ws = new Swoole\WebSocket\Server("0.0.0.0", 9502);

$ws->on('open', function ($ws, $request) {
    $ws->push($request->fd, "连接成功");
    echo "客户端：$request->fd 连接成功\n";
});

//监听WebSocket客户端消息事件
$ws->on('message', function ($ws, $frame) {
    $ws->push($frame->fd, "server: {$frame->data}");
});

//监听WebSocket客户端连接关闭事件
$ws->on('close', function ($ws, $fd) {
    echo "客户端：{$fd} 断开连接\n";
});

//启动WebSocket 服务
$ws->start();
```

## 解析

### 第一步

创建websocket服务器对象，监听0.0.0.0:9502端口

```php
$ws = new Swoole\WebSocket\Server("0.0.0.0", 9502);
```

### 第二步

监听WebSocket客户端连接打开事件

```php
$ws->on('open', function ($ws, $request) {
    $ws->push($request->fd, "连接成功");
    echo "客户端：$request->fd 连接成功\n";
});
```

### 第三步

监听WebSocket客户端消息事件

```php
$ws->on('message', function ($ws, $frame) {
    $ws->push($frame->fd, "server: {$frame->data}");
});
```

### 第四步

监听WebSocket客户端连接关闭事件

```php
$ws->on('close', function ($ws, $fd) {
    echo "客户端：{$fd} 断开连接\n";
});
```

### 第五步

启动WebSocket 服务

```php
$ws->start();
```



## 客户端连接 Websocket 服务

### 代码

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
客户端页面
<script>
    var wsServer = 'ws://127.0.0.1:9502';
    var websocket = new WebSocket(wsServer);
    websocket.onopen = function (evt) {
        console.log("WebSocket 连接成功！");
    };

    websocket.onclose = function (evt) {
        console.log("WebSocket 连接关闭！");
    };

    websocket.onmessage = function (evt) {
        console.log('接收到消息内容: ' + evt.data);
    };

    websocket.onerror = function (evt, e) {
        console.log('连接出现错误: ' + evt.data);
    };

</script>
</body>
</html>
```

### 解析

#### 第一步

js 连接 websocket 服务

```javascript
var wsServer = 'ws://127.0.0.1:9502';
var websocket = new WebSocket(wsServer);
websocket.onopen = function (evt) {
    console.log("WebSocket 连接成功！");
};
```

#### 第二步

js 客户端 websocket 连接关闭事件

```javascript
websocket.onclose = function (evt) {
    console.log("WebSocket 连接关闭！");
};
```

#### 第三步

js 客户端接收 websocket 消息内容事件

```javascript
websocket.onmessage = function (evt) {
    console.log('接收到消息内容: ' + evt.data);
};
```

#### 第四步

js 客户端连接 websocket 异常捕获

```javascript
websocket.onerror = function (evt, e) {
    console.log('连接出现错误: ' + evt.data);
};
```

## 结果

#### 启动 WebSocket 服务

```php
php wsServer.php
```

#### 访问 客户单页面 wsServer.html

![image-20200730145542273](https://liudandandear.gitee.io/image/image-20200730145542273.png)

#### 服务端

![image-20200730145706912](https://liudandandear.gitee.io/image/image-20200730145706912.png)

#### 关闭客户单页面 wsServer.html，服务端结果

![image-20200730145805852](https://liudandandear.gitee.io/image/image-20200730145805852.png)



​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**