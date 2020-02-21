<?php

namespace app\common\lib\send\Impl;


use app\common\lib\send\ISendSms;
use app\common\lib\send\base\DingTalk;

class DingTalkImpl implements ISendSms
{

    static $WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=xxxxxx";

    /**
     * @inheritDoc
     */
    function sendCode($phone_num, $code)
    {
        $message = "通知消息:您手机号码 $phone_num 的验证码是: $code " . ",如非本人操作，请忽略本短信。";
        $data = [
            'msgtype' => 'text',
            'text' => array('content' => $message)
        ];
        return DingTalk::sendDingTalk($data);
    }
}