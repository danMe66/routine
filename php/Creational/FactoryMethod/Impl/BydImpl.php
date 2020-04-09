<?php
namespace learing\php\Creational\FactoryMethod\Impl;
/**
 * 比亚迪汽车厂
 * Class BydImpl
 */
class BydImpl implements \learing\php\Creational\FactoryMethod\CarFactory
{

    /**
     * @inheritDoc
     */
    public function createCar()
    {
        echo "我是比亚迪汽车厂制造出来的汽车";
    }
}
