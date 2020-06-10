<?php

class Factory
{
    public function Factory()
    {
        //TODO
    }

    public function create($s)
    {
        switch ($s) {
            case 'B':
            {
                return new iocB();
                break;
            }
            case 'C':
            {
                return new iocC();
                break;
            }
            default:
            {
                return null;
                break;
            }
        }
    }
}

class iocA
{
    public $b;
    public $c;

    public function __construct()
    {
        //TODO
    }

    public function Method()
    {
        $factory = new Factory();
        $this->b = $factory->create('B');
        $this->c = $factory->create('C');

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
