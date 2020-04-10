<?php
function __autoload($className)
{
    $filename = __DIR__ . "/" . $className . ".php";
    $filename = str_replace('\\', '/', $filename);
    //is_readable() 函数判断指定文件名是否可读。
    if (is_readable($filename)) {
        require $filename;
    }
}