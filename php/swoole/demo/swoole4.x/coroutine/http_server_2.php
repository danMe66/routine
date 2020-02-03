<?php
go(function () {
    $server = new Co\Http\Server("127.0.0.1", 8812);
    $server->handle("/websocket", function ($request, $ws) {
        $ws->upgrade();//向客户端发送websocket握手信息
        while (true) {
            $data = $ws->recv();
//            var_dump($data);
            if (!$data->data) {
                echo "没有数据" . PHP_EOL;
                break;
            }
            echo "收到客户端发送的数据为：" . $data->data . PHP_EOL;
            $ws->push("hello ws client");
        }
    });
    $server->handle("/", function ($request, $response) {
        if ($request->server['request_uri'] == "/favicon.ico") {
            $response->end("not data");
            return;
        }
        echo "abc" . PHP_EOL;
        $response->end("<h1>hi swoole</h1>");
    });
    $server->start();
});