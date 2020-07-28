<?php
$result = sendHB(200, 50);
var_export($result);
echo array_sum($result);

/**
 * 拼手气红包实现
 * 生成num个随机数，每个随机数占随机数总和的比例*money_total的值即为每个红包的钱额
 * 考虑到精度问题，最后重置最大的那个红包的钱额为money_total-其他红包的总额
 * 浮点数比较大小,使用number_format,精确到2位小数
 *
 * @param double $money_total 总钱额， 每人最少0.01,精确到2位小数
 * @param int $num 发送给几个人
 * @return array num个元素的一维数组，值是随机钱额
 */
function sendHB($money_total, $num)
{
    if ($money_total < $num * 0.01) {
        exit('钱太少');
    }

    $rand_arr = array();
    for ($i = 0; $i < $num; $i++) {
        $rand = rand(1, 100);
        $rand_arr[] = $rand;
    }

    $rand_sum = array_sum($rand_arr);
    $rand_money_arr = array();
    $rand_money_arr = array_pad($rand_money_arr, $num, 0.5);  //保证每个红包至少0.01

    foreach ($rand_arr as $key => $r) {
        $rand_money = number_format($money_total * $r / $rand_sum, 2);

        if ($rand_money <= 0.01 || number_format(array_sum($rand_money_arr), 2) >= number_format($money_total, 2)) {
            $rand_money_arr[$key] = 0.01;
        } else {
            $rand_money_arr[$key] = $rand_money;
        }

    }

    $max_index = $max_rand = 0;
    foreach ($rand_money_arr as $key => $rm) {
        if ($rm > $max_rand) {
            $max_rand = $rm;
            $max_index = $key;
        }
    }

    unset($rand_money_arr[$max_index]);
    //这里的array_sum($rand_money_arr)一定是小于$money_total的
    $rand_money_arr[$max_index] = number_format($money_total - array_sum($rand_money_arr), 2);

    ksort($rand_money_arr);
    return $rand_money_arr;
}