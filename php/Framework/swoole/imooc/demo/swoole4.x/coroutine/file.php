<?php
Swoole\Runtime::enableCoroutine(true);
go(function () {
    //协程化 文件写操作
    file_put_contents("setTxt.txt", "文件写入的内容！！！");
    //读取文件
    $file = file_get_contents("setTxt.txt");
    mkdir("file_go");
    var_dump($file);
});
