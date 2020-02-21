<?php
//Swoole\Runtime::enableCoroutine(true);
//一键协程化原生php的redis客户端
go(function () {
    $redis = new Redis();
    $redis->connect("127.0.0.1", 6379);

    $value = $redis->get("demoMonth");
    print_r($value);
});