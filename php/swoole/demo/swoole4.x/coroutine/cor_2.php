<?php
Swoole\Runtime::enableCoroutine(true);
//协程
go(function () {
//    co::sleep(1);//IO异步的
    sleep(3);//堵塞的
    echo "协程1" . PHP_EOL;
});

echo "协程 hello world" . PHP_EOL;

Swoole\Coroutine::create(function () {
    echo "协程2" . PHP_EOL;
});