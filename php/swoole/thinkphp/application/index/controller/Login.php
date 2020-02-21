<?php

namespace app\index\controller;

use app\common\lib\Sms;
use app\common\lib\Util;
use app\common\lib\Redis;

class Send
{
    public function index()
    {
        $phone_num = request()->get('phone_num', 0, 'intval');
        if (empty($phone_num)) {
            return Util::show(config('code.error'), 'err');
        }

        //生成随机数
        $code = rand(1000, 9999);
        try {
            $res = Sms::sendSms($phone_num, $code);
        } catch (\Exception $e) {
            return Util::show(config('code.error'), '短信服务商内部系统异常!!!');
        }
//        $res = true;
        if ($res->isSucc()) {
            $redis = new \Swoole\Coroutine\Redis();
            $redis->connect(config('redis.host'), config('redis.port'));
            $redis->set(Redis::smsKey($phone_num), $code, config('code.out_time'));
            return Util::show(config('code.success'), '验证码发送成功!!!', $res);
        } else {
            return Util::show(config('code.error'), '验证码发送失败!!!');
        }
    }

}