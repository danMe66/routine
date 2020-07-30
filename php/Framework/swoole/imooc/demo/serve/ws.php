<?php
$server = new Swoole\WebSocket\Server("0.0.0.0", 8812);

$server->set([
    'enable_static_handler'=>true,
    'document_root'=>"/Users/liudandan/myFiles/www/learing/php/swoole/data",
]);

$server->on('open', 'onOpen');
function onOpen($server, $request)
{
    print_r($request->fd);
}

/**
 * $frame->fd 哪个客户端
 */
$server->on('message', function (Swoole\WebSocket\Server $server, $frame) {
    echo "receive from {$frame->fd}:{$frame->data},opcode:{$frame->opcode},fin:{$frame->finish}\n";
    //向客户端推送数据
    $server->push($frame->fd, "数据推送成功！");
});

$server->on('close', function ($ser, $fd) {
    echo "客户端 {$fd} 已关闭\n";
});

$server->start();