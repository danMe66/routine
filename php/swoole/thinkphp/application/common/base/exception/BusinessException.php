<?php
/**
 * Created by PhpStorm.
 * User: jack
 * Date: 17-6-23
 * Time: 下午2:21
 */

namespace container\exception;

/**
 * 业务类的错误
 * Class BusinessException
 * @package container\exception
 */
class BusinessException extends BaseException
{
    /**
     * BusinessException constructor.
     * @param array $messageArray [errorMessage,errorCode]
     * @param string $information
     */
    function __construct(array $messageArray, $information='')
    {
        $message = $messageArray[0];
        $code = $messageArray[1];
        parent::__construct($message, $code, $information);
    }

}