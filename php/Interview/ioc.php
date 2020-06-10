<?php

class iocA
{
    public $b;
    public $c;

    public function A()
    {
        //TODO
    }

    public function Method()
    {
        $this->b = new iocB();
        $this->c = new iocC();

        $this->b->Method();
        $this->c->Method();
    }
}

class iocB
{
    public function C()
    {
        //TODO
    }

    public function Method()
    {
        echo 'b';
    }
}

class iocC
{
    public function C()
    {
        //TODO
    }

    public function Method()
    {
        //TODO
        echo 'c';
    }
}

$a = new iocA();
$a->Method();
