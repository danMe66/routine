<?php

namespace FactoryMethod;
use FactoryMethod\Impl\BmImpl;
use FactoryMethod\Impl\BydImpl;

include_once __DIR__ . "./../autoload.php";

/**
 * 现在我们去买汽车
 * Class RunFactory
 */
class RunFactory
{
    public function shopCar($money)
    {
        if ($money > 10000) {
            $car = new BmImpl();
        } else {
            $car = new BydImpl();
        }
        $car->createCar();
    }
}

$car = new RunFactory();
$car->shopCar(999);