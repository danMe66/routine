<?php
go(function () {
    $client = new Swoole\Coroutine\Http\Client('yaf.test');
    $client->set([
        //超时时间
        "timeout" => 1
    ]);
    $client->get("/api/user");
    print_r($client->body);
//    print_r($client->statusCode);
    $client->close();
});