# php基础-数据类型-string和int比较

> 在php中，string 类型和 int 类型相比较，string 类型的值会被转为 int 类型，实质上是两个 int 类型的数值相互比较。

## 代码：

```php
<?php
$a = 'c';
$b = 0;
var_dump($a == $b);//输出true
$c = 1;
var_dump($a == $c);//输出false
$d = true;
var_dump($a == $d);//输出true
$c = false;
var_dump($a == $c);//输出false
```



## 从以上结果发现：

- string 类型的值和 int 类型的值比较，会被转为 int 类型的 0，也就是 true
- string 类型的值和 bool 类型的值比较，会被转为 bool 类型的 true 







**[点击返回主页](https://liudandandear.gitee.io)**