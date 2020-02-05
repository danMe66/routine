<?php
Swoole\Runtime::enableCoroutine(true);
//一键协程化原生php的redis客户端
go(function () {
    echo "1-go-start" . PHP_EOL;
    //TODO::堵塞的IO操作，此处也是一个协程client，交出协程调度权，给其他协程(开启：Swoole\Runtime::enableCoroutine(true);)
    //TODO::等同于一个 非堵塞的IO场景
    $redis = new Redis();
    $redis->connect("127.0.0.1", 6379);

    $key = "demo1212";
    $value = $redis->set($key, 999999);
    $value = $redis->get($key);
    print_r($value);
    echo PHP_EOL;
    echo "1-go-end" . PHP_EOL;
});

echo "demo swoole" . PHP_EOL;

go(function () {
    echo "2-go-start" . PHP_EOL;
});