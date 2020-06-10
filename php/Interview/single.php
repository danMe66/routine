<?php

class Single
{
    private static $instance;

    private function __clone()
    {
    }

    private function __construct()
    {
    }

    public static function getInstance()
    {
        if (self::$instance === NULL) self::$instance = new self();
        return self::$instance;
    }
}

$obj1 = Single::getInstance();
$obj2 = Single::getInstance();

// 用 === 可以判断两个变量是否指向同一个对象
var_dump($obj1 === $obj2);