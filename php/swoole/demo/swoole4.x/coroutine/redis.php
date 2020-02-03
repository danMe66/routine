<?php
go(function () {
    $redis = new Swoole\Coroutine\Redis();
    $redis->setOptions([
        'connection_timeout' => 1,
        'timeout' => 3,
    ]);
    $redis->connect("127.0.0.1", 6379);
    $key = "demo";
    $value = $redis->set($key,222);
    $value = $redis->get($key);
    var_dump($value);
});