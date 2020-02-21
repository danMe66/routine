<?php

namespace app\common\base\exception;

/**
 * 不可预料的值,主要用于请求值与预期不同的情况
 * Class UnexpectedValueException
 * @package container\exception
 */
class UnexpectedValueException extends BaseException
{

    /**
     * UnexpectedValueException constructor.
     * @param int $code
     * @param string $information
     */
    function __construct($code, $information)
    {
        parent::__construct('不可预料的值', $code, $information);
    }
}