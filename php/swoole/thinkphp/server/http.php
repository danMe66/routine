<?php

use think\Container;

$http = new swoole_http_server("0.0.0.0", 8811);

$http->set([
    'enable_static_handler' => true,
    'document_root' => "/Users/liudandan/myFiles/www/learing/php/swoole/thinkphp/public/static",
    'worker_num' => 5
]);
$http->on("WorkerStart", function (swoole_server $server, $worker_id) {
    // 定义应用目录
    define('APP_PATH', __DIR__ . '/../application/');
    // 加载基础文件
    require __DIR__ . '/../thinkphp/base.php';
//    require __DIR__ . '/../thinkphp/start.php';
});
$http->on("request", function ($request, $response) use ($http) {
    print_r($request->server);
    if (isset($request->server)) {
        foreach ($request->header as $k => $v) {
            $_SERVER[strtoupper($k)] = $v;
        }
    }

//    if (!empty($_GET)) {
//        unset($_GET);
//    }

    if (isset($request->get)) {
        foreach ($request->get as $k => $v) {
            $_GET[$k] = $v;
        }
    }
    if (isset($request->post)) {
        foreach ($request->post as $k => $v) {
            $_POST[$k] = $v;
        }
    }
    ob_start();
    try {
        // 执行应用并响应
        Container::get('app', [APP_PATH ? APP_PATH : ''])
            ->run()
            ->send();
    } catch (\Exception $e) {
        echo "error";
    }
    //输出控制器方法
//    echo "-action-" . request()->action() . PHP_EOL;
    $res = ob_get_contents();
    ob_end_clean();
    $response->end($res);
    $http->close();
});

$http->start();
