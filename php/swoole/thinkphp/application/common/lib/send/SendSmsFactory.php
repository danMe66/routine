<?php


namespace app\common\lib\send;

use app\common\base\exception\UnexpectedValueException;
use app\common\lib\send\enum\SmsProvider;
use app\common\lib\send\Impl\DingTalkImpl;
use app\common\lib\send\Impl\YunPianImpl;
use ReflectionException;

class SendSmsFactory
{
    /**
     * 获取实例化的对象
     * @param $provider
     * @return DingTalkImpl|YunPianImpl
     */
    public static function GetInstance($provider)
    {
        switch ($provider) {
            case SmsProvider::YunPian:
                return new YunPianImpl();
            case SmsProvider::DingTalk:
                return new DingTalkImpl();
            default:
                throwException('not support provider');
        }
    }

    /**
     * 根据名称获取实例化的对象
     * @param $provider
     * @return mixed
     * @throws ReflectionException
     * @throws UnexpectedValueException
     */
    public static function GetInstanceByName($provider)
    {
        $provider = SendSmsFactory::GetProviderByName($provider);
        return SendSmsFactory::GetInstance($provider);
    }

    /**
     * 根据字符串读取枚举
     * @param $provider
     * @return mixed|null
     * @throws ReflectionException
     * @throws UnexpectedValueException
     */
    public static function GetProviderByName($provider)
    {
        //查出枚举类中的数组
        $enumClass = (new SmsProvider());
        $reflect = new \ReflectionClass($enumClass);
        $enum = $reflect->getConstants();
        foreach ($enum as $item) {
            if (strtolower($provider) === strtolower($enumClass->getString($item))) {
                return $item;
            }
        }
        return null;
    }
}