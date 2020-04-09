<?php

namespace learing\php\Creational\FactoryMethod;
/**
 * 现在我们去买汽车
 * Class RunFactory
 */
class RunFactory
{
    public function shopCar($money)
    {
        if ($money > 10000) {
            $car = new \learing\php\Creational\FactoryMethod\Impl\BmImpl();
        } else {
            $car = new \learing\php\Creational\FactoryMethod\Impl\BydImpl();
        }
        $car->createCar();
    }
}

$car = new RunFactory();
$car->shopCar(999);