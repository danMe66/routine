/**
 * @file function-test-2.cpp
 * @author your name (you@domain.com)
 * @brief 函数指针调用
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>

using namespace std;

// 函数定义-指针传参
void swap(int *x, int *y);
int main()
{
    int x = 1;
    int y = 2;
    cout << "交换前 x等于:" << x << "       y等于:" << y << endl;
    // ERROR:错误点：获取参数的指针语法：&参数
    swap(&x, &y);
    cout << "交换后 x等于:" << x << "       y等于:" << y << endl;
    return 0;
}

// 实现swap函数
void swap(int *x, int *y)
{
    // ERROR:错误点：参数传递一直是引用传递（地址传递）
    int tmp;
    tmp = *x,
    *x = *y;
    *y = *x;
}