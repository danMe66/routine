<?php

class iocA
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

$a = new iocA(new iocB(), new iocC());
$a->Method();
