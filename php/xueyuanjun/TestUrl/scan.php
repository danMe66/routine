<?php
require __DIR__ . '/vendor/autoload.php';

//实例化 GuzzleHttp 客户端
$client = new GuzzleHttp\Client();
$csv = \League\Csv\Reader::createFromPath($argv[1]);

foreach ($csv as $csvRow) {
    try {
        $httpResponse = $client->get($csvRow[0]);
        if ($httpResponse->getStatusCode() >= 400) {
            throw new Exception();
        }
    } catch (Exception $e) {
        echo $csvRow[0] . PHP_EOL;
    }
}