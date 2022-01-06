// JavaScript的函数其实都指向某个变量。既然变量可以指向函数，函数的参数能接收变量，那么一个函数就可以接收另一个函数作为参数，这种函数就称之为高阶函数。
// 一个最简单的高阶函数：
'use strict';
function add(x, y, f) {
    return f(x) + f(y);
}
// 当我们调用add(-5, 6, Math.abs)时，参数x，y和f分别接收-5，6和函数Math.abs，根据函数定义，我们可以推导计算过程为：
// x = -5;
// y = 6;
// f = Math.abs;
// f(x) + f(y) ==> Math.abs(-5) + Math.abs(6) ==> 11;
// return 11;

var x = add(-5, 6, Math.abs); // 11
console.log(x);
// 编写高阶函数，就是让函数的参数能够接收别的函数。

// URL::https://www.liaoxuefeng.com/wiki/1022910821149312/1023021271742944
