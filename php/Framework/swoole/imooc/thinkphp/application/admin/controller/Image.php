<?php

namespace app\admin\controller;

use app\common\lib\Util;
use think\Exception;

class Image
{
    public function index()
    {
        if ($file = request()->file('file')) {
            $info = $file->move('../public/static/upload');
            if ($info) {
                $data = [
                    'image' => config('live.host') . "/upload/" . $info->getSaveName(),
                ];
                return Util::show(config('code.success'), 'ok', $data);
            } else {
                return Util::show(config('code.error'), 'error');
            }
        } else {
            return Util::show(config('code.error'), '文件不合法');
        }

    }
}