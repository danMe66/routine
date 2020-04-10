<?php

use app\common\lib\send\SendSmsFactory;
use app\common\lib\Util;

class Http
{
    const HOST = "0.0.0.0";
    const PORT = 8811;
    public $http = null;

    public function __construct()
    {
        $this->http = new Swoole_http_server(self::HOST, self::PORT);

        $this->http->set([
            'enable_static_handler' => true,
            'document_root' => "/Users/liudandan/myFiles/www/learing/php/swoole/thinkphp/public/static",
            'worker_num' => 4,
            'task_worker_num' => 4
        ]);
        $this->http->on('workerstart', [$this, "onWorkerStart"]);
        $this->http->on('request', [$this, "onRequest"]);
        $this->http->on('task', [$this, "onTask"]);
        $this->http->on('finish', [$this, "onFinish"]);
        $this->http->on('close', [$this, "onClose"]);
        $this->http->start();
    }

    public function onWorkerStart($server, $worker_id)
    {
        //定义目录
        // 定义应用目录
        define('APP_PATH', __DIR__ . '/../application/');
        // 加载基础文件
//        require __DIR__ . '/../thinkphp/base.php';
        require __DIR__ . '/../thinkphp/start.php';
    }

    public function onRequest($request, $response)
    {
        //define('APP_PATH', __DIR__ . '/../application/');
        //require __DIR__ . '/../thinkphp/base.php';
        $_SERVER = [];
        if (isset($request->server)) {
            foreach ($request->server as $k => $v) {
                $_SERVER[strtoupper($k)] = $v;
            }
        }
        if (isset($request->header)) {
            foreach ($request->header as $k => $v) {
                $_SERVER[strtoupper($k)] = $v;
            }
        }

        $_GET = [];
        if (isset($request->get)) {
            foreach ($request->get as $k => $v) {
                $_GET[$k] = $v;
            }
        }
        $_POST = [];
        if (isset($request->post)) {
            foreach ($request->post as $k => $v) {
                $_POST[$k] = $v;
            }
        }

        $_POST['http_serve'] = $this->http;
        ob_start();
        // 执行应用并响应
        try {
            think\Container::get('app', [APP_PATH])
                ->run()
                ->send();
        } catch (\Exception $e) {
            // todo
        }

        $res = ob_get_contents();
        ob_end_clean();
        $response->end($res);
    }

    /**
     * @param $serv
     * @param $taskId
     * @param $workerId
     * @param $data
     */
    public function onTask($serv, $taskId, $workerId, $data)
    {
        //分发 task 任务机制，让不同的任务走不同的逻辑
        $obj = new \app\common\lib\task\Task;
        $method = $data['method'];
        return $obj->$method($data['data']);
    }

    /**
     * @param $serv
     * @param $taskId
     * @param $data
     */
    public function onFinish($serv, $taskId, $data)
    {
        echo "TaskId为：{$taskId}\n";
        echo "finish successful:{$data}\n";
    }

    public function onClose($ws, $fd)
    {
        echo "连接关闭：{$fd}\n";
    }
}

new Http();
