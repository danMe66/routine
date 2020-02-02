<?php
//TODO:学习慕课网4-1：Swoole--Tcp服务器

$serv = new Swoole\Server("127.0.0.1", 9501);

//设置运行时参数（参数文档说明：https://wiki.swoole.com/wiki/page/274.html）
$serv->set([
    'worker_num' => 4,//worker进程数：cpu的 1-4 倍数
    'max_request' => 1000,//每个worker进程允许处理的最大业务数
//    'daemonize' => true,
//    'backlog' => 128,
]);

/**
 * 连接注册事件
 * $fd 客户端连接的唯一标识
 * $reactor_id 线程ID
 */
$serv->on('connect', function ($serv, $fd, $reactor_id) {
    echo "TCP 连接已建立{$reactor_id} -- $fd -- \n";
});

/**
 * 监听数据接收事件
 * $fd 客户端连接的唯一标识
 * $reactor_id 线程ID
 */
$serv->on('receive', function ($serv, $fd, $reactor_id, $data) {
    $serv->send($fd, "接收数据：{$reactor_id} - {$fd}\n" . $data);
});

/**
 * 连接关闭事件
 */
$serv->on('close', function ($serv, $fd) {
    echo "{$fd}连接关闭！.\n";
});
//启动服务器
$serv->start();