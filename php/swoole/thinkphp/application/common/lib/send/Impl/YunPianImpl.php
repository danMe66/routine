<?php

namespace app\common\lib\send\Impl;

use app\common\lib\send\ISendSms;
use Yunpian\Sdk\YunpianClient;

ini_set("display_errors", "on");

require_once APP_PATH . '/../extend/yunpian-sdk/vendor/autoload.php';

class YunPianImpl implements ISendSms
{
    static $API_KEY = '6c85e785699ed73a7ab135f7bf27c85b';

    /**
     * @inheritDoc
     */
    function sendCode($phone_num, $code)
    {
        //初始化client,apikey作为所有请求的默认值
        $client = YunpianClient::create(static::$API_KEY);
        $param = [
            YunpianClient::MOBILE => $phone_num,
            YunpianClient::TEXT => '【PHP基础网】您的验证码是' . $code . '。如非本人操作，请忽略本短信。'
        ];
        $res = $client->sms()->single_send($param);
        if ($res->isSucc()) {
            return [
                "errcode" => 0,
                "errmsg" => $res->data(),
            ];
        } else {
            return false;
        }
    }
}
