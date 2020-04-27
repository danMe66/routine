<?php

namespace AbstractFactory\base;

use AbstractFactory\AssembleInterface;

/**
 * 车轮组件车间
 * Class Wheel
 */
abstract class Wheel implements AssembleInterface
{
    protected $name = "XXX车轮组装部";
    /**
     * 大小
     * @var string
     */
    protected $size;

    /**
     * 重量
     * @var string
     */
    protected $weight;

    /**
     * Shell constructor.
     * @param $name
     * @param int $size
     * @param int $weight
     */
    public function __construct($name, $size, $weight)
    {
        $this->name = $name;
        $this->size = $size;
        $this->weight = $weight;
    }
}