<?php

/**
 * setter 方法注入
 * Class IocC
 */
class IocC
{
    private $db;

    private $file;

    function setDb($db)
    {
        $this->db = $db;
    }

    function setFile($file)
    {
        $this->file = $file;
    }
}

class file
{
    public function __construct()
    {
        echo "file 的 构造函数执行了" . "\n";
    }

    public function run()
    {
        echo "file 的 run" . "\n";
    }
}

class db
{
    public function __construct()
    {
        echo "db 的 构造函数执行了" . "\n";
    }

    public function run()
    {
        echo "db 的 run" . "\n";
    }
}

$iocC = new IocC();
$iocC->setdb(new db());
$iocC->setfile(new file());