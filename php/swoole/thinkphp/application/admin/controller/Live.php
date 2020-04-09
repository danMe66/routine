<?php

namespace app\admin\controller;

use app\common\lib\redis\Predis;
use app\common\lib\Util;

class Live
{
    public function push()
    {
        if (empty($_GET)) {
            return Util::show(config('code.error'), 'error');
        }
        $teams = [
            1 => [
                'name' => '马刺',
                'logo' => '/live/imgs/team1.png',
            ],
            4 => [
                'name' => '火箭',
                'logo' => '/live/imgs/team2.png',
            ],
        ];
        $data = [
            'type' => intval($_GET['type']),
            'title' => '直播员',
            'logo' =>  'logo',
            'content' => '无消息',
            'image' => 'image',
        ];
        var_dump($data);
        $clients = Predis::getInstance()->sMembers(config('redis.live_game_key'));
        foreach ($clients as $fd) {
            print_r("房间号：" . $fd);
            $_POST['http_server']->push($fd, json_encode($data));
        }
//        if (empty($_GET)) {
//            return Util::show(config('code.error'), 'error');
//        }
//        $teams = [
//            1 => [
//                'name' => '马刺',
//                'logo' => '/live/imgs/team1.png',
//            ],
//            4 => [
//                'name' => '火箭',
//                'logo' => '/live/imgs/team2.png',
//            ],
//        ];
//        $data = [
//            'type' => intval($_GET['type']),
//            'title' => !empty($teams[$_GET['team_id']]['name']) ? $teams[$_GET['team_id']]['name'] : '直播员',
//            'logo' => !empty($teams[$_GET['team_id']]['logo']) ? $teams[$_GET['team_id']]['logo'] : '直播员',
//            'content' => !empty($_GET['content']) ? $teams[$_GET['content']] : '无消息',
//            'image' => !empty($_GET['image']) ? $teams[$_GET['image']] : '',
//        ];
//        //获取连接的用户
//////        print_r($_GET);
//        //赛况信息入库
//        //组织好之后，push到直播页面
//        $clients = Predis::getInstance()->sMembers(config('redis.live_game_key'));
////        foreach ($clients as $fd) {
//            print_r("房间号：" . $fd);
//            $_POST['http_server']->push($fd, json_encode($data));
//        }
    }

}