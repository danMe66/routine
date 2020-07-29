<?php

function bubbleSort(array $arr)
{
    $counts = count($arr);
    if ($counts <= 0) return;
    for ($i = 0; $i < $counts; $i++) {
        for ($j = $counts - 1; $j > $i; $j--) {
            if ($arr[$j] < $arr[$j - 1]) {
                $tmp = $arr[$j];
                $arr[$j] = $arr[$j - 1];
                $arr[$j - 1] = $tmp;
            }
        }
    }
    return $arr;
}

echo "冒泡排序-正序" . "\n";
$arr = array(1, 12, 16, 7, 9);
$results = bubbleSort($arr);
var_dump($results);

# 冒泡排序原理：
# 比较两个相邻的元素，将值大的元素换到右边

# 冒泡排序思路：
# 依次比较相邻的两个数，将比较小的数放在前边，比较大的数放在后边。