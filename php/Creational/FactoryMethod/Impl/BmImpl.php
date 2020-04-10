<?php
namespace FactoryMethod\Impl;
use FactoryMethod\CarFactory;

/**
 * 宝马汽车厂
 * Class BmImpl
 */
class BmImpl implements CarFactory
{

    /**
     * @inheritDoc
     */
    public function createCar()
    {
        echo "我是宝马汽车厂制造出来的汽车";
    }
}