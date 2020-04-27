<?php

namespace AbstractFactory\base;

use AbstractFactory\AssembleInterface;

/**
 * 外壳组件车间
 * Class Shell
 */
abstract class Shell implements AssembleInterface
{
    protected $name = "XXX外壳组装部";
    /**
     * @var string
     */
    protected $color;

    /**
     * Shell constructor.
     * @param $name
     * @param string $color 外壳颜色
     */
    public function __construct($name, $color = '')
    {
        $this->name = $name;
        $this->color = $color;
    }
}