/**
 * @file 16-pointers.cpp
 * @author your name (you@domain.com)
 * @brief 指针
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// 每一个变量都有一个内存位置，每一个内存位置都定义了可使用连字号（&）运算符访问的地址，
// 它表示了在内存中的一个地址。请看下面的实例，它将输出定义的变量地址：

// 什么是指针？

// 指针是一个变量，其值为另一个变量的地址，即，内存位置的直接地址。就像其他变量或常量一样，您必须在使用指针存储其他变量地址之前，对其进行声明。
// 指针变量声明的一般形式为：
// type *var-name;
// 指针声明
// int    *ip;    /* 一个整型的指针 */
// double *dp;    /* 一个 double 型的指针 */
// float  *fp;    /* 一个浮点型的指针 */
// char   *ch;    /* 一个字符型的指针 */

// 使用指针
#include <iostream>

using namespace std;

int main()
{
    // 实际变量的声明
    int var = 20;
    // 指针变量的声明
    int *ip;
    // 在指针变量中存储 var 的地址
    ip = &var;
    cout << "var 的值等于: ";
    cout << var << endl;

    // 输出在指针变量中存储的地址
    cout << "指正变量ip对应的存储地址为: ";
    cout << ip << endl;

    // 访问指针中地址的值
    cout << "指正变量ip对应的存储地址的值为: ";
    cout << *ip << endl;

    return 0;
}