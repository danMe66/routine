<?php

namespace app\common\lib\task;

use app\common\lib\redis\Predis;
use app\common\lib\send\SendSmsFactory;
use app\common\lib\Redis;

/**
 * 代表 swoole 里边所有的 task 异步任务都到这里来处理
 * Class Task
 * @package app\common\lib\task
 */
class Task
{
    /**
     * 异步发送验证码
     * @param $data
     * @param $serv
     * @return bool
     */
    public function sendSms($data, $serv)
    {
        try {
            $sendSms = SendSmsFactory::GetInstanceByName(config('sms.smsProvider'));
            $res = $sendSms->sendCode($data['phone'], $data['code']);
        } catch (\Exception $e) {
            return false;
        }
        if ($res) {
            //记录redis
            Predis::getInstance()->set(Redis::smsKey($data['phone']), $data['code'], config('redis.out_time'));
        } else {
            return false;
        }
        return true;
    }

    /**
     * 通过task机制发送赛况实时数据给客户端
     * @param $data
     * @param $serv swoole server对象
     */
    public function pushLive($data, $serv)
    {
        $clients = Predis::getInstance()->sMembers(config("redis.live_game_key"));

        foreach ($clients as $fd) {
            $serv->push($fd, json_encode($data));
        }
    }
}