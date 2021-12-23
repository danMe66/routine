// 总结：学些数据类型和变量，以及JavaScript的一些特性
alert('开始学JavaScript的第一天!');
alert('The first day of learning JavaScript!');
var a = 1;
if(2>a){
    alert('a less than 2')
}else(
    alert('a greater than 1')
)
// 数据类型和变量
// Number：JavaScript不区分整数和浮点型，统一用Number表示，一下都是合法的Number类型
123; // 整数123
0.456; // 浮点数0.456
1.2345e3; // 科学计数法表示1.2345x1000，等同于1234.5
-99; // 负数
NaN; // NaN表示Not a Number，当无法计算结果时用NaN表示
Infinity; // Infinity表示无限大，当数值超过了JavaScript的Number所能表示的最大值时，就表示为Infinity
// Number 可以做四则运算
1 + 2; // 3
(1 + 2) * 5 / 2; // 7.5
2 / 0; // Infinity
0 / 0; // NaN
10 % 3; // 1
10.5 % 3; // 1.5
// 注意%是求余运算
// 字符串："" ''

// 布尔值
true; // 这是一个true值
false; // 这是一个false值
2 > 1; // 这是一个true值
2 >= 3; // 这是一个false值
// &&运算是与运算，只有所有都为true，&&运算结果才是true：
true && true; // 这个&&语句计算结果为true
true && false; // 这个&&语句计算结果为false
false && true && false; // 这个&&语句计算结果为false
// ||运算是或运算，只要其中有一个为true，||运算结果就是true：
false || false; // 这个||语句计算结果为false
true || false; // 这个||语句计算结果为true
false || true || false; // 这个||语句计算结果为true
// !运算是非运算，它是一个单目运算符，把true变成false，false变成true：
! true; // 结果为false
! false; // 结果为true
! (2 > 5); // 结果为true
// 布尔值经常用在条件判断中，比如：
var age = 15;
if (age >= 18) {
    alert('adult');
} else {
    alert('teenager');
}
// 比较运算符
2 > 5; // false
5 >= 2; // true
7 == 7; // true
//实际上，JavaScript允许对任意数据类型做比较：
false == 0; // true
false === 0; // false
// 要特别注意相等运算符==。JavaScript在设计时，有两种比较运算符：

// 第一种是==比较，它会自动转换数据类型再比较，很多时候，会得到非常诡异的结果；

// 第二种是===比较，它不会自动转换数据类型，如果数据类型不一致，返回false，如果一致，再比较。

// 由于JavaScript这个设计缺陷，不要使用==比较，始终坚持使用===比较。

// 另一个例外是NaN这个特殊的Number与所有其他值都不相等，包括它自己：
NaN === NaN; // false
// 唯一能判断NaN的方法是通过isNaN()函数：
isNaN(NaN); // true
// 最后要注意浮点数的相等比较
1 / 3 === (1 - 2 / 3); // false
// 这不是JavaScript的设计缺陷。浮点数在运算过程中会产生误差，因为计算机无法精确表示无限循环小数。要比较两个浮点数是否相等，只能计算它们之差的绝对值，看是否小于某个阈值：
Math.abs(1 / 3 - (1 - 2 / 3)) < 0.0000001; // true

//null和undefined
// null表示一个“空”的值，它和0以及空字符串''不同，0是一个数值，''表示长度为0的字符串，而null表示“空”。

// 在其他语言中，也有类似JavaScript的null的表示，例如Java也用null，Swift用nil，Python用None表示。但是，在JavaScript中，还有一个和null类似的undefined，它表示“未定义”。

// JavaScript的设计者希望用null表示一个空的值，而undefined表示值未定义。事实证明，这并没有什么卵用，区分两者的意义不大。大多数情况下，我们都应该用null。undefined仅仅在判断函数参数是否传递的情况下有用。

//数组
// 数组是一组按顺序排列的集合，集合的每个值称为元素。JavaScript的数组可以包括任意数据类型。例如：
[1, 2, 3.14, 'Hello', null, true];
// 上述数组包含6个元素。数组用[]表示，元素之间用,分隔。
// 另一种创建数组的方法是通过Array()函数实现：
new Array(1, 2, 3); // 创建了数组[1, 2, 3]
// 然而，出于代码的可读性考虑，强烈建议直接使用[]。

// 数组的元素可以通过索引来访问。请注意，索引的起始值为0：
var arr = [1, 2, 3.14, 'Hello', null, true];
arr[0]; // 返回索引为0的元素，即1
arr[5]; // 返回索引为5的元素，即true
arr[6]; // 索引超出了范围，返回undefined

//对象
// JavaScript的对象是一组由键-值组成的无序集合，例如：
var person = {
    name: 'Bob',
    age: 20,
    tags: ['js', 'web', 'mobile'],
    city: 'Beijing',
    hasCar: true,
    zipcode: null
};
// JavaScript对象的键都是字符串类型，值可以是任意数据类型。上述person对象一共定义了6个键值对，其中每个键又称为对象的属性，例如，person的name属性为'Bob'，zipcode属性为null。

// 要获取一个对象的属性，我们用对象变量.属性名的方式：
person.name; // 'Bob'
person.zipcode; // null

// 变量
// 变量的概念基本上和初中代数的方程变量是一致的，只是在计算机程序中，变量不仅可以是数字，还可以是任意数据类型。

// 变量在JavaScript中就是用一个变量名表示，变量名是大小写英文、数字、$和_的组合，且不能用数字开头。变量名也不能是JavaScript的关键字，如if、while等。申明一个变量用var语句，比如：
var a; // 申明了变量a，此时a的值为undefined
var $b = 1; // 申明了变量$b，同时给$b赋值，此时$b的值为1
var s_007 = '007'; // s_007是一个字符串
var Answer = true; // Answer是一个布尔值true
var t = null; // t的值是null
// 在JavaScript中，使用等号=对变量进行赋值。可以把任意数据类型赋值给变量，同一个变量可以反复赋值，而且可以是不同类型的变量，但是要注意只能用var申明一次，例如：
var a = 123; // a的值是整数123
a = 'ABC'; // a变为字符串
// 这种变量本身类型不固定的语言称之为动态语言，与之对应的是静态语言。静态语言在定义变量时必须指定变量类型，如果赋值的时候类型不匹配，就会报错。例如Java是静态语言，赋值语句如下：
// int a = 123; // a是整数类型变量，类型用int申明
// a = "ABC"; // 错误：不能把字符串赋给整型变量
console.log(s_007)
// 使用console.log()代替alert()的好处是可以避免弹出烦人的对话框。

// strict模式
// JavaScript在设计之初，为了方便初学者学习，并不强制要求用var申明变量。这个设计错误带来了严重的后果：如果一个变量没有通过var申明就被使用，那么该变量就自动被申明为全局变量：
i = 10; // i现在是全局变量
// 在同一个页面的不同的JavaScript文件中，如果都不用var申明，恰好都使用了变量i，将造成变量i互相影响，产生难以调试的错误结果。

// 使用var申明的变量则不是全局变量，它的范围被限制在该变量被申明的函数体内（函数的概念将稍后讲解），同名变量在不同的函数体内互不冲突。

// 为了修补JavaScript这一严重设计缺陷，ECMA在后续规范中推出了strict模式，在strict模式下运行的JavaScript代码，强制通过var申明变量，未使用var申明变量就使用的，将导致运行错误。

// 启用strict模式的方法是在JavaScript代码的第一行写上：
'use strict';
// 这是一个字符串，不支持strict模式的浏览器会把它当做一个字符串语句执行，支持strict模式的浏览器将开启strict模式运行JavaScript。
// 来测试一下你的浏览器是否能支持strict模式：
'use strict';
// 如果浏览器支持strict模式，
// 下面的代码将报ReferenceError错误:
abc = 'Hello, world';
console.log(abc);


// 练习：https://www.liaoxuefeng.com/wiki/1022910821149312/1023020925712064