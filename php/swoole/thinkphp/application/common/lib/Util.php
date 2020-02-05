<?php

namespace app\common\lib;

class Util
{
    public static function show($status, $message = '', $data = [])
    {
        $results = [
            'status' => $status,
            'message' => $message,
            'data' => $data,
        ];
        return json_encode($results);
    }

}