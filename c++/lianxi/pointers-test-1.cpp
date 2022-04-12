/**
 * @file pointers-test-1.cpp
 * @author your name (you@domain.com)
 * @brief 指针
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */

// 指针变量的申明
// 实际指针地址的获取

#include <iostream>

using namespace std;

int main()
{
    int a = 100;

    cout << "变量a的值为:" << a << endl;

    cout << "变量a的指针为:" << &a << endl;

    //声明指针变量
    int *address;

    // 指针中地址的值
    address = &a;

    cout << "变量a的指针对应的值为:" << *address << endl;
    // *address也等于*&a
    cout << "变量a的指针对应的值为:" << *&a << endl;
}