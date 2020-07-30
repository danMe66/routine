<?php

/**
 * 优化 websocket 基础类库
 * Class wsClass
 * TODO::先启动本类
 * TODO::然后启动 http.php
 * TODO::访问http://127.0.0.1:8811/ws.html
 */
class wsClass
{
    const HOST = "0.0.0.0";
    const PORT = 8812;
    public $ws = null;

    public function __construct()
    {
        $this->ws = new Swoole\WebSocket\Server('0.0.0.0', 8812);

        $this->ws->set([
            'worker_num' => 2,
            'task_worker_num' => 2
        ]);
        $this->ws->on('open', [$this, "onOpen"]);
        $this->ws->on('message', [$this, "onMessage"]);
        $this->ws->on('task', [$this, "onTask"]);
        $this->ws->on('finish', [$this, "onFinish"]);
        $this->ws->on('close', [$this, "onClose"]);
        $this->ws->start();
    }

    /**
     * 监听 websocket 连接事件
     * @param $ws
     * @param $request
     */
    public function onOpen($ws, $request)
    {
        var_dump($request->fd);
        echo "fd为：$request->fd \n";
        if ($request->fd == 1) {
            //间隔时钟定时器
            swoole_timer_tick(2000, function ($timer_id) {
                echo "这是2s输出一次消息，timer_id 为:{$timer_id}\n";
            });
        }
    }

    /**
     * 监听 ws 消息事件
     * @param $ws
     * @param $frame
     */
    public function onMessage($ws, $frame)
    {
        echo "服务器接收到消息：{$frame->data}\n";
        //todo:10s
        $data = [
            'task' => 1,
            'fd' => $frame->fd,
        ];
//        $ws->task($data);
        swoole_timer_after(5000, function () use ($ws, $frame) {
            echo "这是5s之后输出的消息!";
            //给网页客户端发送消息
            $ws->push($frame->fd, "这是5s后执行的消息代码！");
        });
        $ws->push($frame->fd, "发送给客户端的消息：" . date("Y-m-d H:i:s"));
    }

    /**
     * @param $serv
     * @param $taskId
     * @param $workerId
     * @param $data
     */
    public function onTask($serv, $taskId, $workerId, $data)
    {
        print_r($data);
        //模拟耗时场景
        sleep(10);
        return "耗时任务10s后执行完成!";
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

$object = new wsClass();