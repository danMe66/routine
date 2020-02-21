<?php

namespace app\common\lib\send\base;

/**
 * 钉钉机器人
 * Class DingTalk
 * @package app\common\lib\send\base
 * @link 钉钉文档：https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 */
class DingTalk
{
    static $WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=5a09891883d0c2c431b75a8d3a8667900868373323bd18014a6031361e8ca7f1";

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