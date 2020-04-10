<?php
go(function () {
    $client = new Swoole\Coroutine\Client(SWOOLE_SOCK_TCP);
    if (!$client->connect('127.0.0.1', 9501)) {
        echo "连接失败！" . $client->errCode . PHP_EOL;
    } else {
        $client->send("连接成功！\n");
        echo $client->recv();
        $client->close();
    }
});