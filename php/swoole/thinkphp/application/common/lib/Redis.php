<?php

namespace app\common\lib;

class Redis
{
    public static $pre = 'sms_';

    public static function smsKey($phoneNum)
    {
        return self::$pre . $phoneNum;
    }
}