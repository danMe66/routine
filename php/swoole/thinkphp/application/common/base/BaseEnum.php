<?php

namespace app\common\base;

use app\common\base\exception\UnexpectedValueException;

/**
 * 自定义枚举的实现，枚举支持数字或是纯字符串，其他的定义应该报异常.严格区分大小写
 * 枚举应继承自此类，枚举值需要用const修饰
 * 错误码也应该定义成常量 [错误码，错误描述]
 * Class BaseEnum
 * @package container\strongType
 */
class BaseEnum
{

    /**
     * @var bool 是否需要检查枚举的默认值，默认只能是数字或字符串
     */
    private $checkValue = true;

    public function __construct($checkValue = true)
    {
        $this->checkValue = $checkValue;
    }

    /**
     * 获取枚举值的名称
     * @param $value
     * @return int|string
     * @throws UnexpectedValueException
     */
    public function getString($value)
    {

        if ($this->checkValue) {
            // 防止出现 false null 与 0 相等的情况
            if (is_null($value) || is_bool($value)) {
                throw new UnexpectedValueException(-1, '枚举值只可是数字或字符串');
            }

            if (!is_string($value) && !is_numeric($value)) {
                throw new UnexpectedValueException(-1, '枚举值只可是数字或字符串');
            }
        }

        $reflect = new \ReflectionClass($this);
        $enum = $reflect->getConstants();
        foreach ($enum as $name => $enumValue) {
            if ($value == $enumValue) {
                return $name;
            }
        }

        throw new UnexpectedValueException(-1, '不存在的枚举定义');
    }

    /**
     * 根据名称返回枚举的值
     * @param $enumName
     * @return mixed
     * @throws UnexpectedValueException
     */
    public function getValue($enumName)
    {
        $reflect = new \ReflectionClass($this);
        $enum = $reflect->getConstant($enumName);
        if ($enum === false) {
            throw new UnexpectedValueException(-1, '不存在的枚举定义');
        }
        return $enum;
    }

    public function getValueList()
    {
        $reflect = new \ReflectionClass($this);
        $enum = $reflect->getConstants();

        $value = array_values($enum);
        return $value;
    }

    /**
     * 返回枚举的可用值列表
     * @return array
     * @throws UnexpectedValueException
     */
    public function getNameList()
    {
        $reflect = new \ReflectionClass($this);
        $enum = $reflect->getConstants();

        if ($this->checkValue) {
            $value = array_values($enum);
            foreach ($value as $item) {
                if (!is_numeric($item) && !is_string($item)) {
                    throw new UnexpectedValueException(-1, '错误的枚举定义，只能是数字或是字符串');
                }
            }
        }

        $enum = array_keys($enum);

        return $enum;
    }

    /**
     * 判断给定的值与给定的枚举是否相等
     * @param string $object 枚举的值或名称
     * @param string $enumValue 枚举的值
     * @return bool
     */
    public function equals($object, $enumValue)
    {
        $value = $this->getValue($object);
        if ($value == $enumValue) {
            return true;
        }

        return false;
    }

    /**
     * 判断给定的枚举名称或值是否存在
     * @param $nameOrValue
     * @return bool
     */
    public function isExist($nameOrValue)
    {
        //ReflectionClass::hasConstant — 检查常量是否已经定义
        $reflect = new \ReflectionClass($this);
        $name = $reflect->hasConstant($nameOrValue);
        if ($name !== false) {
            return true;
        }

        $enum = $reflect->getConstant($nameOrValue);
        if ($enum !== false) {
            return true;
        }
        return false;
    }

    /**
     * 获取枚举的详细信息
     * @return array
     * @throws UnexpectedValueException
     */
    public function getInformation()
    {
        $reflect = new \ReflectionClass($this);
        $enum = $reflect->getConstants();
        $data = [];
        foreach ($enum as $item) {
            $data[$item] = array(
                'value' => $item,
                'name' => $this->getString($item),
            );
        }
        return $data;
    }
}