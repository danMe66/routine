<?php
$a = true;
$b = 0;
$c = null;
$d = false;
$e = '';

#region empty() 和 isset() 的对比
//empty() 函数用于检查一个变量是否为空。
//empty() 判断一个变量是否被认为是空的。
//当一个变量并不存在，或者它的值等同于 FALSE，那么它会被认为不存在。
//如果变量不存在的话，empty()并不会产生警告。
var_dump('empty()检查变量是否为空');
var_dump(empty($a));//false
var_dump(empty($b));//true
var_dump(empty($c));//true
var_dump(empty($d));//true
var_dump(empty($e));//true

var_dump('isset()函数用于检测变量是否已设置并且非NULL');
var_dump(isset($a));//true
var_dump(isset($b));//true
var_dump(isset($c));//false
var_dump(isset($d));//true
var_dump(isset($e));//true
#endregion

#region echo，print，print_r，var_dump的区别
var_dump('echo，print，print_r，var_dump的区别');
$abc = 123;
$arr = ['name' => 'dawson', 'age' => 12];
echo 'echo 输出数组' . json_encode($arr) . "\n";
print 'print 输出数组' . json_encode($arr) . "\n";
print_r('print_r 输出数组' . json_encode($arr) . "\n");
var_dump('var_dump 输出数组' . json_encode($arr) . "\n");
#endregion