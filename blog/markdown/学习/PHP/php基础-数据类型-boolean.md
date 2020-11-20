# php基础-数据类型-boolean

> 这是最简单的类型，boolean 表达了真值，可以为 true 或者 false

## 语法

要指定一个布尔值，使用常量 true 或 false 。两个都不区分大小写。

```php
<?php
$foo = True; // 设置 $foo 为 TRUE
?>
```

通常运算符所返回的 boolean 值结果会被传递给控制流程。

```php
<?php
// == 是一个操作符，它检测两个变量是否相等，并返回一个布尔值
if ($action == "show_version") {
    echo "The version is 1.23";
}

// 这样做是不必要的...
if ($show_separators == TRUE) {
    echo "<hr>\n";
}

// ...因为可以使用下面这种简单的方式：
if ($show_separators) {
    echo "<hr>\n";
}
```



## 转换为布尔值

要明确的将一个值转换为 boolean ，用 （bool）或者 （boolean）来强制转换。但是很多情况下不需要用强制转换，因为当运算符，函数或者流程控制结构需要一个 boolean 参数时，该值会被自动转换。



## 当转换为 boolean 时，以下值被认为是 FALSE

- 布尔值 false 本身
- 整型值 0（零）及 -0（零）
- 浮点型值 0.0（零）-0.0（零）
- 空字符串，以及字符串 "0"
- 不包括任何元素的数组
- 特殊类型 NULL（包括尚未赋值的变量） 
- 从空标记生成的 SimpleXML 对象

> 所有其他值都被认为是 TRUE （包括任何资源和nan）
>
> Warning ：-1 和其它非零值（不论正负）一样，被认为是 TRUE。

```php
<?php
var_dump((bool) "");        // bool(false)
var_dump((bool) 1);         // bool(true)
var_dump((bool) -2);        // bool(true)
var_dump((bool) "foo");     // bool(true)
var_dump((bool) 2.3e5);     // bool(true)
var_dump((bool) array(12)); // bool(true)
var_dump((bool) array());   // bool(false)
var_dump((bool) "false");   // bool(true)
?>
```







**[点击返回主页](https://liudandandear.gitee.io)**