<?php

namespace app\common\lib\task;

use app\common\lib\redis\Predis;
use app\common\lib\send\SendSmsFactory;
use app\common\lib\Redis;
use app\common\lib\Util;

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
     * @return bool
     */
    public function sendSms($data)
    {
        try {
            $sendSms = SendSmsFactory::GetInstanceByName(config('sms.smsProvider'));
            $res = $sendSms->sendCode($data['phone'], $data['code']);
        } catch (\Exception $e) {
            return false;
        }
        if ($res) {
            //记录redis
            Predis::getInstance()->set(Redis::smsKey($data['phone']),$data['code'], config('redis.out_time'));
        } else {
            return false;
        }
        return true;
    }
}