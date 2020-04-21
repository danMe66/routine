<?php

namespace AbstractFactory\plugs;

/**
 * 车轮组件车间
 * Class Wheel
 */
abstract class Wheel implements AssembleInterface
{
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
     * @param int $size
     * @param int $weight
     */
    public function __construct($size, $weight)
    {
        $this->size = $size;
        $this->weight = $weight;
    }
}