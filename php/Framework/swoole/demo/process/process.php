<?php
$process = new swoole_process(function (swoole_process $pro) {
//TODO::子进程执行一些东西
    $pro->exec("php", [__DIR__ . '/../serve/http.php']);
}, false);
$pid = $process->start();
echo $pid . PHP_EOL;

swoole_process::wait();