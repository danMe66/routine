<?php


namespace AbstractFactory;

use AbstractFactory\Impl\BmImpl;
use AbstractFactory\Impl\BydImpl;

include_once __DIR__ . "./../autoload.php";

class Run
{
    public function getFactory()
    {
        return array(
            array(new BmImpl()),
            array(new BydImpl()),
        );
    }

    /**
     *
     * @dataProvider getFactory
     * @param AbstractFactory $abstractFactory
     * @return void
     */
    public function index(AbstractFactory $abstractFactory)
    {
        $factory = array(
            $abstractFactory->createWheel('牛逼'),
            $abstractFactory->createShell('不牛逼'),
        );
        $this->assertContainsOnly('AbstractFactory\AssembleInterface', $factory);
    }
}

$car = new Run();
$car->index();