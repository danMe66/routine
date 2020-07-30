<?php


namespace app\common\lib\send;


interface ISendSms
{
    /**
     * 发送验证码
     * @param $phone_num
     * @param $code
     * @return mixed
     */
    function sendCode($phone_num, $code);
}