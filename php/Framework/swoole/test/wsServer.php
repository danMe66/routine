<?php
$ws = new Swoole\WebSocket\Server("0.0.0.0", 9502);

//监听WebSocket客户端连接打开事件
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