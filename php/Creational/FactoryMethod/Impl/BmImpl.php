<?php
namespace learing\php\Creational\FactoryMethod\Impl;
/**
 * 宝马汽车厂
 * Class BmImpl
 */
class BmImpl implements \learing\php\Creational\FactoryMethod\CarFactory
{

    /**
     * @inheritDoc
     */
    public function createCar()
    {
        echo "我是宝马汽车厂制造出来的汽车";
    }
}