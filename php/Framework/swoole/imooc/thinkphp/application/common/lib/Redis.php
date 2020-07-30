<?php

namespace app\common\lib;

class Redis
{
    public static $sms_pre = 'sms_';
    public static $user_pre = 'user_';

    public static function smsKey($phoneNum)
    {
        return self::$sms_pre . $phoneNum;
    }

    public static function userKey($phoneNum)
    {
        return self::$user_pre . $phoneNum;
    }
}