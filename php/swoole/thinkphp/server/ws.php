<?php

use app\common\lib\send\SendSmsFactory;
use app\common\lib\Util;

class Ws
{
    const HOST = "0.0.0.0";
    const PORT = 8811;
    public $ws = null;

    public function __construct()
    {
        $this->ws = new swoole_websocket_server(self::HOST, self::PORT);

        $this->ws->set([
            'enable_static_handler' => true,
            'document_root' => "/Users/liudandan/www/learing/php/swoole/thinkphp/public/static",
            'worker_num' => 4,
            'task_worker_num' => 4
        ]);
        $this->ws->on('open', [$this, "onOpen"]);
        $this->ws->on('message', [$this, "onMessage"]);
        $this->ws->on('workerstart', [$this, "onWorkerStart"]);
        $this->ws->on('request', [$this, "onRequest"]);
        $this->ws->on('task', [$this, "onTask"]);
        $this->ws->on('finish', [$this, "onFinish"]);
        $this->ws->on('close', [$this, "onClose"]);
        $this->ws->start();
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

        $_FILES = [];
        if (isset($request->files)) {
            foreach ($request->files as $k => $v) {
                $_FILES[$k] = $v;
            }
        }

        $_POST = [];
        if (isset($request->post)) {
            foreach ($request->post as $k => $v) {
                $_POST[$k] = $v;
            }
        }

        $_POST['http_server'] = $this->ws;
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

    /**
     * 监听 websocket 连接事件
     * @param $ws
     * @param $request
     */
    public function onOpen($ws, $request)
    {
        //将 fd 存入 redis 有序集合
        \app\common\lib\redis\Predis::getInstance()->sAdd(config('redis.live_game_key'), $request->fd);
        var_dump($request->fd);
    }

    /**
     * 监听 ws 消息事件
     * @param $ws
     * @param $frame
     */
    public function onMessage($ws, $frame)
    {
        echo "服务器接收到消息：{$frame->data}\n";
        $ws->push($frame->fd, "发送给客户端的消息：" . date("Y-m-d H:i:s"));
    }

    public function onClose($ws, $fd)
    {
        //将 fd 从 redis 有序集合中删除
        \app\common\lib\redis\Predis::getInstance()->sRem(config('redis.live_game_key'), $fd);
        echo "连接关闭：{$fd}\n";
    }
}

new Ws();
