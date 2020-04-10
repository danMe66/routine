<?php
echo "开始时间：" . date("Ymd H:i:s");
$workers = [];
$urls = [
    'http://baidu.com',
    'http://sina.com.cn',
    'http://qq.com',
    'http://baidu.com?search=12'
];

//多进程执行
for ($i = 0; $i < 4; $i++) {
    $process = new swoole_process(function (swoole_process $worker) use ($i, $urls) {
        //curl
        $content = curlData($urls[$i]);
        //echo $content.PHP_ROL
        $worker->write($content . PHP_EOL);
    }, true);
    $pid = $process->start();
    $workers[$pid] = $process;
}

foreach ($workers as $process) {
    echo $process->read();
}

/**
 * 模拟请求URL
 * @param $url
 * @return string
 */
function curlData($url)
{
    sleep(1);
    return $url . "seccess" . PHP_EOL;
}

echo "结束时间：" . date("Ymd H:i:s");