<?php


namespace app\common\lib\send\Impl;


use app\common\lib\send\ISendSms;

class DingTalk implements ISendSms
{

    static $WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=xxxxxx";

    /**
     * @inheritDoc
     */
    function sendCode($phone_num, $code)
    {
        $message = [];
        $data = [
            'msgtype' => 'text',
            'text' => array('content' => $message)
        ];
    }
}