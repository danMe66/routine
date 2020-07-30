<?php

class Server
{
    private $serv;

    public function __construct()
    {
        $this->serv = new Swoole\WebSocket\Server("0.0.0.0", 9501);
        $this->serv->set([
            'task_worker_num' => 10,
            'enable_coroutine' => true,
            'task_enable_coroutine' => true
        ]);
        $this->serv->on('open', function ($serv, $request) {
        });
        $this->serv->on('message', function ($serv, $frame) {
            $serv->task($frame->data);
        });
        $this->serv->on('task', function ($serv, $task) {
            foreach ($serv->connections as $fd) {
                $connectionInfo = $serv->connection_info($fd);
                if (isset($connectionInfo['websocket_status']) && intval($connectionInfo['websocket_status']) == 3) {
                    $serv->push($fd, $task->data);
                }
            }
        });
        $this->serv->on('finish', function ($serv, $task_id, $data) {
        });
        $this->serv->on('close', function ($serv, $fd) {
        });
        $this->serv->start();
    }
}

$server = new Server();