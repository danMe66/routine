<?php

namespace app\common\base\exception;

/**
 * 业务类异常建议 BusinessException
 * Class exception
 * @package base 基础异常类，所有业务的异常均需要继承于此.除此异常外的异常均为系统级的异常
 */
class BaseException extends \Exception
{

    /**
     * @var string 用于错误描述的调试性信息
     */
    public $extraInformation;

    /**
     * exception constructor.
     * @param string|array $message 错误信息
     * @param int|string $code 错误编号
     * @param string $information 调试信息
     */
    function __construct($message, $code = 0, $information = '')
    {

        if (is_array($message) && empty($information)) {
            // 此处的逻辑是借用businessException中的逻辑
            $information = $code;
            $code = $message[1];
            $message = $message[0];
        }

        $this->message = $message;
        $this->code = $code;
        $this->extraInformation = $information;
    }

    /**
     * @return string 获取调试信息
     */
    public function getDebugMessage()
    {
        return $this->extraInformation;
    }
}