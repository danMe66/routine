# php基础-数据类型-string

一个字符串 string 就是由一系列的字符组成，其中每个字符等同于一个字节。

这意味着 PHP 只能支持 256 的字符集，因此不支持 Unicode。

> string 最大可以达到 2GB。

## 语法

一个字符串可以用4种方式表达：

- 单引号
- 双引号
- heredoc 语法结构
- nowdoc 语法结构（自 php5.5.0 起）

### 单引号

定义给个字符串的最简单的方法是用单引号把它包围起来。

要表达一个单引号自身，需要在它的前边加个反斜线（\）来转义。

要表达一个反斜线自身，则用两个反斜线（\\）。

其他任何方式的反斜线都会被当成反斜线本身；也就是说如果想使用其他转义序列，例如 \r 或者 \n，并不代表任何特殊含义，就单纯是这两个字符本身。

> 不像 [双引号](https://www.php.net/manual/zh/language.types.string.php#language.types.string.syntax.double) 和 [heredoc](https://www.php.net/manual/zh/language.types.string.php#language.types.string.syntax.heredoc) 语法结构，在单引号字符串中的 [变量](https://www.php.net/manual/zh/language.variables.php) 和特殊字符的转义序列将*不会*被替换。

```php
<?php
echo 'this is a simple string';

// 可以录入多行
echo 'You can also have embedded newlines in 
strings this way as it is
okay to do';

// 输出： Arnold once said: "I'll be back"
echo 'Arnold once said: "I\'ll be back"';

// 输出： You deleted C:\*.*?
echo 'You deleted C:\\*.*?';

// 输出： You deleted C:\*.*?
echo 'You deleted C:\*.*?';

// 输出： This will not expand: \n a newline
echo 'This will not expand: \n a newline';

// 输出： Variables do not $expand $either
echo 'Variables do not $expand $either';
?>
```

### 双引号

如果字符串是包围在双引号（""）中，PHP 将对一些特殊的字符进行解析。

| 序列                 | 含义                                                         |
| :------------------- | ------------------------------------------------------------ |
| `\n`                 | 换行（ASCII 字符集中的 LF 或 0x0A (10)）                     |
| `\r`                 | 回车（ASCII 字符集中的 CR 或 0x0D (13)）                     |
| `\t`                 | 水平制表符（ASCII 字符集中的 HT 或 0x09 (9)）                |
| `\v`                 | 垂直制表符（ASCII 字符集中的 VT 或 0x0B (11)）（自 PHP 5.2.5 起） |
| `\e`                 | Escape（ASCII 字符集中的 ESC 或 0x1B (27)）（自 PHP 5.4.0 起） |
| `\f`                 | 换页（ASCII 字符集中的 FF 或 0x0C (12)）（自 PHP 5.2.5 起）  |
| `\\`                 | 反斜线                                                       |
| `\$`                 | 美元标记                                                     |
| `\"`                 | 双引号                                                       |
| `\[0-7]{1,3}`        | 符合该正则表达式序列的是一个以八进制方式来表达的字符         |
| `\x[0-9A-Fa-f]{1,2}` | 符合该正则表达式序列的是一个以十六进制方式来表达的字符       |

和单引号字符串一样，转义任何其他字符串都会导致反斜线被显示出来。php5.1.1以前，`\{$var}` 中的反斜线还不会被显示出来。

用双引号定义的字符串最重要的特征是就是变量会被解析。

### Heredoc 结构

第三种表达字符串的方法是用 heredoc 句法结构：`<<<`。在该运算符之后要提供一个标识符，然后换行。接下来是字符串 string 本身，最后要用前面定义的标识符作为结束标志。

结束时所引用的标识符*必须*在该行的第一列，而且，标识符的命名也要像其它标签一样遵守 PHP 的规则：只能包含字母、数字和下划线，并且必须以字母和下划线作为开头。