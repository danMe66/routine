<?php

/**
 * 构造器注入
 * 定义一个有构造函数的类
 * Class IocB
 */
class iocAA
{
    public $b;

    public $c;

    public function __construct($iocB, $iocC)
    {
        $this->b = $iocB;
        $this->c = $iocC;
    }

    public function Method()
    {
        $this->b->Method();
        $this->c->Method();
    }
}

class IocB
{

    public function Method()
    {
        echo '我是 IocB 的 Method 方法';
    }
}

class IocC
{
    public function Method()
    {
        echo '我是 IocC 的 Method 方法';
    }
}

//进行实例化类的时候，对构造函数的两个参数进行实例化赋值（将实例化后的对象赋值给 iocAA 类 的两个属性）
$a = new iocAA(new IocB(), new IocC());
//然后调用对象的方法即可
$a->Method();