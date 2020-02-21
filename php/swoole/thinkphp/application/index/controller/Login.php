<?php

namespace app\index\controller;

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
    }

}