<?php

namespace app\index\controller;

class Index
{
    public function index()
    {
        print_r($_GET);
        echo "swoole-tp-demo";
    }

    public function test()
    {
        echo "this is test function!!!";
    }

    public function hello($name = 'ThinkPHP5')
    {
        return 'hello,' . $name;
    }
}
