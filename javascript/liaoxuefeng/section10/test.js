// 全局变量会绑定到window上，不同的JavaScript文件如果使用了相同的全局变量，或者定义了相同名字的顶层函数，都会造成命名冲突，并且很难被发现。
// 减少冲突的一个方法是把自己的所有变量和函数全部绑定到一个全局变量中。例如：
// 唯一的全局变量MYAPP:
var MYAPP = {};

// 其他变量:
MYAPP.name = 'myapp';
MYAPP.version = 1.0;

// 其他函数:
MYAPP.foo = function () {
    return 'foo';
};
console.log(MYAPP);
// 把自己的代码全部放入唯一的名字空间MYAPP中，会大大减少全局变量冲突的可能。
//许多著名的JavaScript库都是这么干的：jQuery，YUI，underscore等等。


// 局部作用域
//由于JavaScript的变量作用域实际上是函数内部，我们在for循环等语句块中是无法定义具有局部作用域的变量的：
function foo() {
    for (var i = 0; i < 100; i++) {
        //
    }
    i += 100; // 仍然可以引用变量i
}
//为了解决块级作用域，ES6引入了新的关键字let，用let替代var可以申明一个块级作用域的变量：

'use strict';

function foo() {
    var sum = 0;
    for (let i = 0; i < 100; i++) {
        sum += i;
        console.log(i);
    }
    // SyntaxError:
    i += 1;
}
// alert("输出foo方法")
// foo();

// 常量
//由于var和let申明的是变量，如果要申明一个常量，在ES6之前是不行的，我们通常用全部大写的变量来表示“这是一个常量，不要修改它的值”：
var PI = 3.14;
// ES6标准引入了新的关键字const来定义常量，const与let都具有块级作用域：
'use strict';

// const PI = 3.14;
// PI = 3; // 某些浏览器不报错，但是无效果！
// PI; // 3.14

// 解构赋值
//从ES6开始，JavaScript引入了解构赋值，可以同时对一组变量进行赋值。
//什么是解构赋值？我们先看看传统的做法，如何把一个数组的元素分别赋值给几个变量：
var array = ['hello', 'JavaScript', 'ES6'];
var x = array[0];
var y = array[1];
var z = array[2];
// 现在，在ES6中，可以使用解构赋值，直接对多个变量同时赋值：
// 如果浏览器支持解构赋值就不会报错:
var [x, y, z] = ['hello', 'JavaScript', 'ES6'];
// x, y, z分别被赋值为数组对应元素:
console.log('x = ' + x + ', y = ' + y + ', z = ' + z);
//注意，对数组元素进行解构赋值时，多个变量要用[...]括起来。
// 如果数组本身还有嵌套，也可以通过下面的形式进行解构赋值，注意嵌套层次和位置要保持一致：
let [a, [b, c]] = ['hello', ['JavaScript', 'ES6']];
a; // 'hello'
b; // 'JavaScript'
c; // 'ES6'
console.log('a = ' + a + ', b = ' + b + ', c = ' + c)
// 解构赋值还可以忽略某些元素：
let [, , f] = ['hello', 'JavaScript', 'ES6']; // 忽略前两个元素，只对z赋值第三个元素
f; // 'ES6'
//如果需要从一个对象中取出若干属性，也可以使用解构赋值，便于快速获取对象的指定属性：
var person = {
    name: '小明',
    age: 20,
    gender: 'male',
    passport: 'G-12345678',
    school: 'No.4 middle school'
};
var { name, age, passport } = person;
console.log('person :>> ', person);
console.log('name :>> ', name);
console.log('age :>> ', age);
console.log('passport :>> ', passport);
console.log('name = ' + name + ', age = ' + age + ', passport = ' + passport);

// 对一个对象进行解构赋值时，同样可以直接对嵌套的对象属性进行赋值，只要保证对应的层次是一致的：
var person = {
    name: '小明',
    age: 20,
    gender: 'male',
    passport: 'G-12345678',
    school: 'No.4 middle school',
    address: {
        city: 'Beijing',
        street: 'No.1 Road',
        zipcode: '100001'
    }
};
var { name, address: { city, zip } } = person;
name; // '小明'
city; // 'Beijing'
zip; // undefined, 因为属性名是zipcode而不是zip
// 注意: address不是变量，而是为了让city和zip获得嵌套的address对象的属性:
address; // Uncaught ReferenceError: address is not defined

//使用解构赋值对对象属性进行赋值时，如果对应的属性不存在，变量将被赋值为undefined，这和引用一个不存在的属性获得undefined是一致的。如果要使用的变量名和属性名不一致，可以用下面的语法获取：
var person = {
    name: '小明',
    age: 20,
    gender: 'male',
    passport: 'G-12345678',
    school: 'No.4 middle school'
};

// 把passport属性赋值给变量id:
let { name, passport: id } = person;
name; // '小明'
id; // 'G-12345678'
// 注意: passport不是变量，而是为了让变量id获得passport属性:
passport; // Uncaught ReferenceError: passport is not defined

// 解构赋值还可以使用默认值，这样就避免了不存在的属性返回undefined的问题：
var person = {
    name: '小明',
    age: 20,
    gender: 'male',
    passport: 'G-12345678'
};

// 如果person对象没有single属性，默认赋值为true:
var { name, single = true } = person;
name; // '小明'
single; // true

// 有些时候，如果变量已经被声明了，再次赋值的时候，正确的写法也会报语法错误：
// 声明变量:
var x, y;
// 解构赋值:
{ x, y } = { name: '小明', x: 100, y: 200 };
// 语法错误: Uncaught SyntaxError: Unexpected token =
// 这是因为JavaScript引擎把{开头的语句当作了块处理，于是=不再合法。解决方法是用小括号括起来：
({ x, y } = { name: '小明', x: 100, y: 200 });

// 使用场景
// 解构赋值在很多时候可以大大简化代码。例如，交换两个变量x和y的值，可以这么写，不再需要临时变量：
var x = 1, y = 2;
[x, y] = [y, x]
// 快速获取当前页面的域名和路径：
var { hostname: domain, pathname: path } = location;
// 如果一个函数接收一个对象作为参数，那么，可以使用解构直接把对象的属性绑定到变量中。例如，下面的函数可以快速创建一个Date对象：
function buildDate({ year, month, day, hour = 0, minute = 0, second = 0 }) {
    return new Date(year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
}
// 它的方便之处在于传入的对象只需要year、month和day这三个属性：
buildDate({ year: 2017, month: 1, day: 1 });
// Sun Jan 01 2017 00:00:00 GMT+0800 (CST)
// 也可以传入hour、minute和second属性：
buildDate({ year: 2017, month: 1, day: 1, hour: 20, minute: 15 });
// Sun Jan 01 2017 20:15:00 GMT+0800 (CST)
// 使用解构赋值可以减少代码量，但是，需要在支持ES6解构赋值特性的现代浏览器中才能正常运行。目前支持解构赋值的浏览器包括Chrome，Firefox，Edge等。

// URL::https://www.liaoxuefeng.com/wiki/1022910821149312/1023021187855808