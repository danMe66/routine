<?php
//TODO:学习慕课网4-2：Tcp客户端

//连接 swoole tcp 服务
$client = new swoole_client(SWOOLE_SOCK_TCP);
if (!$client->connect('127.0.0.1', 9501)) {
    echo "连接失败！";
    exit;
}
//php cli常量
fwrite(STDOUT, "请输入消息：");
//去掉字符两边的空格
$msg = trim(fgets(STDIN));

//发送消息给tcp server 服务器
$client->send($msg);

//接收来自server的数据
$results = $client->recv();
echo $results;