<?php
$arr = array(1, 12, 16, 7, 9);
//冒泡排序-正序
function bubble_asc($array)
{
    //先计算数组的长度
    $counts = count($array);
    //检查来的值是否正确，长度小于等于0
    if ($counts <= 0) {
        return false;
    }
    //开始第一层循环，循环对比的轮数
    for ($i = 0; $i < $counts; $i++) {
        //第二层循环，查找相邻的元素进行比较
        for ($j = $counts - 1; $j > $i; $j--) {
            //如果后边的元素的值小于前一个元素的值，调换位置
            if ($array[$j] < $array[$j - 1]) {
                $tmp = $array[$j];
                $array[$j] = $array[$j - 1];
                $array[$j - 1] = $tmp;
            }
        }
    }
    return $array;
}

$arr = bubble_asc($arr);
echo "冒泡排序-正序";
var_dump($arr);
