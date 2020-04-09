<?php

namespace app\common\lib\send\base;

/**
 * 钉钉机器人
 * Class DingTalk
 * @package app\common\lib\send\base
 *  钉钉文档：
 * @link https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 */
class DingTalk
{
    static $WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=7c427636b7f8b84629f29fa6559b64586425fd8befbf192d9ea4bd0fd7f77320";

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