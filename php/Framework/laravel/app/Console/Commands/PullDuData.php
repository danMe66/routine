<?php

namespace App\Console\Commands;

use App\Models\Du;
use Illuminate\Console\Command;

class PullDuData extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'pull:du_data';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'PullDuData';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     *
     * @return mixed
     */
    public function handle()
    {
        $this->info("—————————————— start ——————————————");
        $path = storage_path() . '/json/2/app.poizon.com/api/v1/h5/commodity/fire/';
        if (!is_dir($path)) {
            $this->error("文件目录不正确！请检查重试！！！");
            return;
        }
        $results = $this->scanFile($path);
        $this->info("—————————————— end ——————————————");
        //读取文件

        //提取文件
        //入库
    }

    /**
     * 根据文件目录获取下边的文件
     * @param $path
     * @return array
     */
    public function scanFile($path)
    {
//        $spuId = 23609;
//        $spuName = 'THE NORTH FACE Men is 1996 Retro Nuptse Jacket 拼接立领羽绒服 美版 男款 黑色';
        $spuId = 27027;
        $spuName = 'Champion 纯棉宽松系带短裤 黑色';
        $this->info("开始读取目录文件！！！");
        global $result;
        $files = scandir($path);
        $number = 0;
        foreach ($files as $file) {
            if ($file != '.' && $file != '..') {
                if (is_dir($path . '/' . $file)) {
                    scanFile($path . '/' . $file);
                } else {
                    //读取文件
                    $fileContent = json_decode(file_get_contents($path . $file));
                    $number++;
                    $data = json_decode(json_encode($fileContent->data->list), true);
                    array_walk($data, function ($item, $key) use (&$data, $spuId, $spuName) {
                        $data[$key]['spuId'] = $spuId;
                        $data[$key]['spuName'] = $spuName;
                    });
                    $this->insertDataBase($data);
                }
            }
        }
        return $result;
    }

    /**
     * 将读取后的数据写入数据库
     * @param array $data
     */
    public function insertDataBase($data)
    {
        $this->info("数据开始写入！");
        $res = Du::query()->insert($data);
        if ($res) {
            $this->info("数据库写入成功！");
            return;
        }
        $this->error("数据库写入失败！");
    }
}
