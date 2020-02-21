<?php

namespace app\common\lib\send;

use Yunpian\Sdk\YunpianClient;

ini_set("display_errors", "on");

require_once APP_PATH . '/../extend/yunpian-php-sdk/vendor/autoload.php';

/**
 * 验证码推送服务
 * Class Sms
 * @package app\common\lib
 */
class Sms
{
    static $API_KEY = '6c85e785699ed73a7ab135f7bf27c85b';
    static $WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=xxxxxx";

    /**
     * 发送云片短信
     * @param $phone_num
     * @param $code
     * @return mixed
     */
    public static function sendSms($phone_num, $code)
    {
        //初始化client,apikey作为所有请求的默认值
        $client = YunpianClient::create(static::$API_KEY);
        $param = [
            YunpianClient::MOBILE => $phone_num,
            YunpianClient::TEXT => '【PHP基础网】您的验证码是' . $code . '。如非本人操作，请忽略本短信。'
        ];
        return $client->sms()->single_send($param);
    }


    /**
     * 发送钉钉消息
     * @param array $post_string
     * @return bool|false|string
     */
    public static function sendDingTalk($post_string)
    {
        $data = json_encode($post_string);
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, static::$WEB_HOOK);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 5);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json;charset=utf-8'));
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        // 线下环境不用开启curl证书验证, 未调通情况可尝试添加该代码
        // curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0);
        // curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, 0);
        $data = curl_exec($ch);
        curl_close($ch);
        return $data;
    }

}