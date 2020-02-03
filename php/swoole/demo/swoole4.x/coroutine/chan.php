<?php
$chan = new Co\Channel(10);
go(function () use ($chan) {
    $chan->push(['demo1' => "test1"]);
});

go(function () use ($chan) {
    $chan->push(['demo2' => "test2"]);
});

go(function () use ($chan) {
    $j = $chan->length();
//    for ($i = 0; $i < $j; $i++) {
//        $res = $chan->pop();
//        print_r($res);
//    }
    while (true) {
        $res = $chan->pop();
        print_r($res);
    }
});