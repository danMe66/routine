<?php

namespace app\common\lib\redis;

class Predis
{
    public $redis = '';

    private static $_instance = null;

    public static function getInstance()
    {
        if (empty(self::$_instance)) {
            self::$_instance = new self();
        }
        return self::$_instance;
    }

    private function __construct()
    {
        $this->redis = new \Redis();
        $results = $this->redis->connect(config('redis.host'), config('redis.port'), config('redis.timeOut'));
        if ($results == false) {
            throw new \Exception("redis 连接错误!!!");
        }
    }

    /**
     * get
     * @param $key
     * @param $value
     * @param int $time
     * @return bool|string
     */
    public function set($key, $value, $time = 0)
    {
        if (!$key) {
            return '';
        }
        if (is_array($value)) {
            $value = json_encode($value);
        }
        if (!$time) {
            return $this->redis->set($key, $value);
        }
        return $this->redis->setex($key, $time, $value);
    }

    /**
     * set
     * @param $key
     * @return bool|mixed|string
     */
    public function get($key)
    {
        if (!$key) {
            return '';
        }
        return $this->redis->get($key);
    }

    /**
     * 集合总数
     * @param $key
     * @param $value
     * @return int
     */
    public function sMembers($key)
    {
        return $this->redis->sMembers($key);
    }

    public function __call($name, $arguments)
    {
        if (count($arguments) != 2) {
            return '';
        }
        return $this->redis->$name($arguments[0], $arguments[1]);
    }
}