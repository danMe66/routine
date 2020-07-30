<?php

namespace app\index\controller;

use app\common\lib\Sms;
use app\common\lib\Util;
use think\facade\Log;

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

        $taskData = [
            'method' => 'sendSms',
            'data' => [
                'phone' => $phone_num,
                'code' => $code,
            ]
        ];
        $_POST['http_serve']->task($taskData);
        return Util::show(config('code.success'), '验证码发送成功!!!');
    }

}