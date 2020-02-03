<?php
$http = new swoole_http_server("0.0.0.0", 8815);
$http->on("request", function ($request, $response) {
    $client = new Swoole\Coroutine\Http\Client('yaf.test');
    $client->set([
        //超时时间
        "timeout" => 1
    ]);
    $client->get("/api/user");
    print_r($client->body);
    $client->close();
    $response->end("8815端口请求成功");
});
$http->start();