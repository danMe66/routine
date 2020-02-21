<?php

namespace app\common\lib\send\enum;

use app\common\base\BaseEnum;

/**
 *
 * Class SmsProvider
 * @package app\common\lib\send\enum
 */
class SmsProvider extends BaseEnum
{
    /**
     * 云片
     */
    const YunPian = 1;

    /**
     * 自定义钉钉机器人
     */
    const DingTalk = 2;
}