<?php

namespace learing\php\Creational\FactoryMethod;
/**
 * 创建一个汽车工厂接口
 * Interface CarFactory
 */
interface CarFactory
{
    /**
     * 制造汽车的方法
     * @return mixed
     */
    public function createCar();
}