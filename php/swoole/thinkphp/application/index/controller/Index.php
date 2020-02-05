<?php

namespace app\index\controller;

use app\common\lib\Sms;

class Index
{
    public function index()
    {
        return 'index';
    }

    public function singwa()
    {
        echo time();
    }

    public function hello($name = 'ThinkPHP5')
    {
        echo 'hello' . $name . time();
    }

    public function send()
    {
        $sms = new Sms();
        $res = $sms::sendSms();
        header("Content-type=text/html;charset=utf-8");
        echo $res;
    }

}