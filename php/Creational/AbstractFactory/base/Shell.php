<?php

namespace AbstractFactory\base;

use AbstractFactory\AssembleInterface;

/**
 * 外壳组件车间
 * Class Shell
 */
abstract class Shell implements AssembleInterface
{
    /**
     * @var string
     */
    protected $color;

    /**
     * @var string
     */
    protected $carType;

    /**
     * Shell constructor.
     * @param string $color 外壳颜色
     */
    public function __construct($color = '')
    {
        $this->color = $color;
    }
}