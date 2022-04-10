/**
 * @file 13-numbers.cpp
 * @author your name (you@domain.com)
 * @brief 定义数字
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    // 数字定义
    short s;
    int i;
    long l;
    float f;
    double d;

    // 数字赋值
    s = 10;
    i = 1000;
    l = 1000000;
    f = 230.47;
    d = 30949.374;

    // 数字输出
    cout << "short  s :" << s << endl;
    cout << "int    i :" << i << endl;
    cout << "long   l :" << l << endl;
    cout << "float  f :" << f << endl;
    cout << "double d :" << d << endl;

    cout << "--------------- 数学运算 ---------------" << endl;
    // 数学运算
    // 引用数学头文件 <cmath>
    // include <cmath>

    /**
     * @brief 数学运算函数
     * double cos(double);该函数返回弧度角（double 型）的余弦
     * double sin(double);该函数返回弧度角（double 型）的正弦
     * double tan(double);该函数返回弧度角（double 型）的正切
     * double log(double);该函数返回参数的自然对数。
     * double pow(double, double);假设第一个参数为 x，第二个参数为 y，则该函数返回 x 的 y 次方。
     * double hypot(double, double);该函数返回两个参数的平方总和的平方根，也就是说，参数为一个直角三角形的两个直角边，函数会返回斜边的长度。
     * double sqrt(double);该函数返回参数的平方根。
     * int abs(int);该函数返回整数的绝对值。
     * double fabs(double);该函数返回任意一个浮点数的绝对值。
     * double floor(double);该函数返回一个小于或等于传入参数的最大整数。
     */
    // 数学运算
    cout << "sin(d) :" << sin(d) << endl;
    cout << "abs(i)  :" << abs(i) << endl;
    cout << "floor(d) :" << floor(d) << endl;
    cout << "sqrt(f) :" << sqrt(f) << endl;
    cout << "pow( d, 2) :" << pow(d, 2) << endl;

    cout << "--------------- 随机数 ---------------" << endl;
    // 随机数
    // 关于随机数生成器，有两个相关的函数。
    // 一个是 rand()，该函数只返回一个伪随机数。生成随机数之前必须先调用 srand() 函数。

    //设置种子
    srand((unsigned)time(NULL));
    // 生成10个随机数
    for (int i = 0; i < 10; i++)
    {
        int j = rand();
        cout << "第" << i << "个随机数：" << j << endl;
    }

    return 0;
}
