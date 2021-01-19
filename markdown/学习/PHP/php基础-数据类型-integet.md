# php基础-数据类型-integet

> integer 是集合 ℤ = {..., -2, -1, 0, 1, 2, ...} 中的某个数。

## 语法

整型值可以使用十进制，十六进制，八进制或二进制表示，前面可以加上可选的符号（- 或者 +）。 可以用 [负运算符](https://www.php.net/manual/zh/language.operators.arithmetic.php) 来表示一个负的integer。

二进制表达的 integer 自 PHP 5.4.0 起可用。

要使用八进制表达，数字前必须加上 `0`（零）。要使用十六进制表达，数字前必须加上 `0x`。要使用二进制表达，数字前必须加上 `0b`。

从 PHP 7.4.0 开始，整型数值可能会包含下划线 (`_`)，为了更好的阅读体验，这些下划线在展示的时候，会被 PHP 过滤掉。

### **Example #1 整数文字表达**

```php
<?php
$a = 1234; // 十进制数
$a = 0123; // 八进制数 (等于十进制 83)
$a = 0x1A; // 十六进制数 (等于十进制 26)
$a = 0b11111111; // 二进制数字 (等于十进制 255)
$a = 1_234_567; // 整型数值 (PHP 7.4.0 以后)
?>
```

## 整数溢出

如果给定的一个数超出了 integer 的范围，将会被解释为 float。同样如果执行的运算结果超出了 integer 范围，也会返回 float。

### **Example #2 32 位系统下的整数溢出**

```php
<?php
$large_number = 2147483647;
var_dump($large_number);                     // int(2147483647)

$large_number = 2147483648;
var_dump($large_number);                     // float(2147483648)

$million = 1000000;
$large_number =  50000 * $million;
var_dump($large_number);                     // float(50000000000)
?>
```

**Example #3 64 位系统下的整数溢出**

```php
<?php
$large_number = 9223372036854775807;
var_dump($large_number);                     // int(9223372036854775807)

$large_number = 9223372036854775808;
var_dump($large_number);                     // float(9.2233720368548E+18)

$million = 1000000;
$large_number =  50000000000000 * $million;
var_dump($large_number);                     // float(5.0E+19)
?>
```

> PHP 中没有整除的运算符。`1/2` 产生出 float `0.5`。 值可以舍弃小数部分，强制转换为 integer，或者使用 [round()](https://www.php.net/manual/zh/function.round.php) 函数可以更好地进行四舍五入。
>
> 从 PHP 7.0.0 开始，函数 [intdiv()](https://www.php.net/manual/zh/function.intdiv.php) 可以用于整数除法。

```php
<?php
var_dump(25/7);         // float(3.5714285714286) 
var_dump((int) (25/7)); // int(3)
var_dump(round(25/7));  // float(4) 
?>
```

## 转换为整形

要明确地将一个值转换为 integer，用 `(int)` 或 `(integer)` 强制转换。不过大多数情况下都不需要强制转换，因为当运算符，函数或流程控制需要一个 integer 参数时，值会自动转换。还可以通过函数 [intval()](https://www.php.net/manual/zh/function.intval.php) 来将一个值转换成整型。

将 resource 转换成 integer 时， 结果会是 PHP 运行时为 resource 分配的唯一资源号。

### 从布尔值转换

**`FALSE`** 将产生出 `0`（零），**`TRUE`** 将产生出 `1`（壹）。

### 从浮点型转换

当从浮点数转换成整数时，将向下取整。

> PHP 7.0.0 起，NaN 和 Infinity 在转换成 integer 时，不再是 undefined 或者依赖于平台，而是都会变成零。
>
> 绝不要将未知的分数强制转换为 integer，这样有时会导致不可预料的结果，比如：

```php
<?php
echo (int) ( (0.1+0.7) * 10 ); // 显示 7!
?>
```

### 从字符串转换

当一个字符串被当作一个数值来取值，其结果和类型如下：

如果该字符串没有包含 '.'，'e' 或 'E' 并且其数字值在整型的范围之内（由 **`PHP_INT_MAX`** 所定义），该字符串将被当成 integer 来取值。其它所有情况下都被作为 float 来取值。

该字符串的开始部分决定了它的值。如果该字符串以合法的数值开始，则使用该数值。否则其值为 0（零）。合法数值由可选的正负号，后面跟着一个或多个数字（可能有小数点），再跟着可选的指数部分。指数部分由 'e' 或 'E' 后面跟着一个或多个数字构成。

```php
<?php
$foo = 1 + "10.5";                // $foo is float (11.5)
$foo = 1 + "-1.3e3";              // $foo is float (-1299)
$foo = 1 + "bob-1.3e3";           // $foo is integer (1)
$foo = 1 + "bob3";                // $foo is integer (1)
$foo = 1 + "10 Small Pigs";       // $foo is integer (11)
$foo = 4 + "10.2 Little Piggies"; // $foo is float (14.2)
$foo = "10.0 pigs " + 1;          // $foo is float (11)
$foo = "10.0 pigs " + 1.0;        // $foo is float (11)     
?>
```

### 从NULL转换

NULL 会转换为零 (`0`)

### 从其它类型转换

Caution 没有定义从其它类型转换为整型的行为。*不要*依赖任何现有的行为，因为它会未加通知地改变







**[点击返回主页](https://liudandandear.gitee.io)**