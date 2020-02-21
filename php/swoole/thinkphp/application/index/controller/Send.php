<?php

namespace app\index\controller;

use app\common\lib\send\SendSmsFactory;
use app\common\lib\Sms;
use app\common\lib\Util;
use app\common\lib\Redis;

class Send
{
    const smsProvider = 'DingTalk';
//    const smsProvider = 'YunPian';

    public function index()
    {
        $phone_num = request()->get('phone_num', 0, 'intval');
        if (empty($phone_num)) {
            return Util::show(config('code.error'), 'err');
        }

        //生成随机数
        $code = rand(1000, 9999);
        try {
            $sendSms = SendSmsFactory::GetInstanceByName(self::smsProvider);
            $res = $sendSms->sendCode($phone_num, $code);
        } catch (\Exception $e) {
            return Util::show(config('code.error'), '短信API异常!!!', $e->getMessage());
        }
        if ($res) {
            $redis = new \Swoole\Coroutine\Redis();
            $redis->connect(config('redis.host'), config('redis.port'));
            $redis->set(Redis::smsKey($phone_num), $code, config('code.out_time'));
            return Util::show(config('code.success'), '验证码发送成功!!!', $res);
        } else {
            return Util::show(config('code.error'), '验证码发送失败!!!');
        }
    }

}