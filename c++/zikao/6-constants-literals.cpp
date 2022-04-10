// 常量
// 常量是固定值，在程序执行期间不会改变。这些固定的值，又叫做字面量。
// 常量可以是任何的基本数据类型，可分为整型数字、浮点数字、字符、字符串和布尔值。
// 常量就像是常规的变量，只不过常量的值在定义后不能进行修改。

// 整数常量
// 整数常量可以是十进制、八进制或十六进制的常量。
// 前缀指定基数：0x 或 0X 表示十六进制，0 表示八进制，不带前缀则默认表示十进制。

// 整数常量也可以带一个后缀，
// 后缀是 U 和 L 的组合，U 表示无符号整数（unsigned），L 表示长整数（long）。
// 后缀可以是大写，也可以是小写，U 和 L 的顺序任意。
// 整数常量的实例：

/**
 * @brief 
*  212        // 合法的
*  215u   // 合法的
*  0xFeeL // 合法的
*  078    // 非法的：8 不是八进制的数字
*  032UU  // 非法的：不能重复后缀
*  // 各种类型的整数常量的实例：
*  85   // 十进制
*  0213 // 八进制
*  0x4b // 十六进制
*  30   // 整数
*  30u  // 无符号整数
*  30l  // 长整数
*  30ul // 无符号长整数
* @brief
*  // 浮点常量
*  // 浮点常量由整数部分、小数点、小数部分和指数部分组成。
*  // 您可以使用小数形式或者指数形式来表示浮点常量。
*  // 当使用小数形式表示时，必须包含整数部分、小数部分，或同时包含两者。
*  // 当使用指数形式表示时， 必须包含小数点、指数，或同时包含两者。带符号的指数是用 e 或 E 引入的。
*  // 浮点常量的实例：
*  3.14159    // 合法的
*  314159E-5L // 合法的
*  510E       // 非法的：不完整的指数
*  210f       // 非法的：没有小数或指数
*  .e55   // 非法的：缺少整数或分数
*/

// 布尔常量
// 布尔常量共有两个，它们都是标准的 C++ 关键字：
// true 值代表真。
// false 值代表假。
// 我们不应把 true 的值看成 1，把 false 的值看成 0。

// const 关键字

#include <iostream>
using namespace std;

int main()
{
    const int LENGTH = 10;
    const int WIDTH = 5;
    const char NEWLINE = '\n';
    int area;

    area = LENGTH * WIDTH;
    cout << area;
    cout << NEWLINE;
    return 0;
}
