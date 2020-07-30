<?php

namespace app\index\controller;

use app\common\lib\redis\Predis;
use app\common\lib\send\Sms;
use app\common\lib\Util;
use app\common\lib\Redis;

class Login
{
    public function index()
    {
        //获取手机号和验证码
        $phone_num = intval($_GET['phone_num']);
        $code = intval($_GET['code']);
        //检验验证码
        if (empty($phone_num) || empty($code)) {
            return Util::show(config('code.error'), '电话或者验证码错误！！！');
        }
        try {
            $redisCode = Predis::getInstance()->get(Redis::smsKey($phone_num));
        } catch (\Exception $e) {
            return Util::show(config('code.error'), $e);
        }
        if ($redisCode == $code) {
            //写入redis
            $data = [
                'user' => $phone_num,
                'srcKey' => md5(Redis::userKey($phone_num)),
                'time' => time(),
                'isLogin' => true
            ];
            Predis::getInstance()->set(Redis::userKey($phone_num), $data);
            return Util::show(config('code.success'), 'ok', $data);
        } else {
            return Util::show(config('code.error'), '登录失败！！！');
        }
    }

}