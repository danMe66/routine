/**
 * @file 12-functions.cpp
 * @author your name (you@domain.com)
 * @brief 函数
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// 函数是一组一起执行一个任务的语句。
// 每个 C++ 程序都至少有一个函数，即主函数 main() ，所有简单的程序都可以定义其他额外的函数。

// 函数声明告诉编译器函数的名称、返回类型和参数。函数定义提供了函数的实际主体。

#include <iostream>
using namespace std;

int sum(int a, int b = 20)
{
    int result;

    result = a + b;

    return (result);
}

int main()
{
    // 局部变量声明
    int a = 100;
    int b = 200;
    int result;

    // 调用函数来添加值
    result = sum(a, b);
    cout << "Total value is :" << result << endl;
    // Total value is :300

    // 再次调用函数
    result = sum(a);
    cout << "Total value is :" << result << endl;
    // Total value is :120

    // Lambda 函数与表达式
    auto fun1 = [](int x, int y)
    { return x < y; };
    // 返回类型可以被明确的指定如下：
    auto fun2 = [](int x, int y) -> int
    {int z = x + y; return z+y };

    std::cout << fun1(1, 2) << std::endl;
    return 0;
}