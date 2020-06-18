<?php
function test($n)
{
    if ($n == 1 || $n == 2) {
        return 1;
    }
    return test($n - 2) + test($n - 1);
}

//https://blog.csdn.net/u010560524/article/details/81503920

$n = 5;
//echo test($n);
echo '==============';

$a = '1';
$b =& $a;
$b = "2$b";
$c = ++$b;
$d = ($c > $b) ? $b : $c;
$e = implode(',', array($a, $b, $c, $d));
echo $e;


interface CarFactory
{
    //制造汽车的方法
    public function createCar();
}

//宝马汽车厂
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

//比亚迪汽车厂
class BydImpl implements CarFactory
{
    public function createCar()
    {
        echo "我是比亚迪汽车厂制造出来的汽车";
    }
}

//买汽车
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