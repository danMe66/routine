<?php
go(function () {
    $server = new Co\Http\Server("127.0.0.1", 8812);
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