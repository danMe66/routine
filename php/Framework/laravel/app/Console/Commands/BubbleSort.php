<?php

namespace App\Console\Commands;

use App\Models\Du;
use Illuminate\Console\Command;

class BubbleSort extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'algorithm:bubble';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = '';

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
        $arr = [2, 3, 5, 1];
//        $type = 'sort';
//        switch ($type) {
//            case 'desc':
//                print_r("冒泡倒序排序\n");
//                $results = $this->desc($arr);
//            case 'sort':
//                print_r("冒泡正序排序\n");
//                $results = $this->sort($arr);
//            default:
////                print_r("快速排序\n");
////                $results = $this->quickSort($arr);
//        }
//        $results = $this->quickSort($arr);
//        print_r("最终结果：\n");
//        print_r($results);
        $this->callN();

    }

    /**
     * 冒泡正序排序
     * @param $arr
     */
    public function sort($arr)
    {
        $counts = count($arr);
        if ($counts <= 1) return $arr;
        //第一个for是外部循环次数
        for ($i = 0; $i < $counts - 1; $i++) {
            //第二个for是内部比较次数
            for ($j = 0; $j < $counts - $i - 1; $j++) {
                if ($arr[$j] > $arr[$j + 1]) {
                    $tmp = $arr[$j];
                    $arr[$j] = $arr[$j + 1];
                    $arr[$j + 1] = $tmp;
                }
            }
            print_r("第" . $i . "比较后的值：");
            print_r($arr);
        }
        return $arr;
    }

    /**
     * 倒序排序
     * @param $arr
     * @return
     */
    public function desc($arr)
    {
        $counts = count($arr);
        if ($counts <= 0) return $arr;
        for ($i = 0; $i < $counts - 1; $i++) {
            for ($j = 0; $j < $counts - $i - 1; $j++) {
                if ($arr[$j] < $arr[$j + 1]) {
                    $tmp = $arr[$j];
                    $arr[$j] = $arr[$j + 1];
                    $arr[$j + 1] = $tmp;
                }
            }
        }
        return $arr;
    }

    /**
     * 快速排序
     * @param $arr
     * @return array
     */
    public function quickSort($arr)
    {
        $len = count($arr);
        if ($len <= 1) return $arr;
        $key = $arr[0];   //把数组的第一个元素作为关键数据
        $left_arr = array();
        $right_arr = array();
        for ($i = 1; $i < count($arr); $i++) {
            if ($arr[$i] <= $key)
                $left_arr[] = $arr[$i];
            else
                $right_arr[] = $arr[$i];
        }
        $left_arr = $this->quickSort($left_arr);
        $right_arr = $this->quickSort($right_arr);
        return array_merge($left_arr, array($key), $right_arr);
    }

    /**
     * 递归
     * @return void
     */
    public function callN()
    {
        static $i = 0;
        print_r($i);
        print_r("\n");
        $i++;
        if ($i < 10) {
            $this->callN();
        }
    }
}
