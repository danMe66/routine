<?php
namespace FactoryMethod\Impl;
use FactoryMethod\CarFactory;

/**
 * 比亚迪汽车厂
 * Class BydImpl
 */
class BydImpl implements CarFactory
{

    /**
     * @inheritDoc
     */
    public function createCar()
    {
        echo "我是比亚迪汽车厂制造出来的汽车";
    }
}
