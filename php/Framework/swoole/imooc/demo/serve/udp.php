<?php
//TODO::创建UDP服务器:https://wiki.swoole.com/wiki/page/477.html
$serv = new Swoole\Server("127.0.0.1", 9502, SWOOLE_PROCESS, SWOOLE_SOCK_UDP);

//设置运行时参数
$serv->set([
    'worker_num' => 4,    //worker process num
    'max_request' => 50,
]);
//监听数据接收事件
$serv->on('Packet', function ($serv, $data, $clientInfo) {
    $serv->sendto($clientInfo['address'], $clientInfo['port'], "Server " . $data);
    var_dump($clientInfo);
});

//启动服务器
$serv->start();