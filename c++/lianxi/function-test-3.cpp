/**
 * @file function-test-3.cpp
 * @author your name (you@domain.com)
 * @brief 引用传递参数
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

// 函数申明
// ERROR-函数声明的时候参数也是引用类型
void swap(int &x, int &b);
int main()
{
    int x = 100;
    int y = 200;
    cout << "交换前x的值等于：" << x << " y的值等于：" << y << endl;
    swap(x, y);
    cout << "交换前x的值等于：" << x << " y的值等于：" << y << endl;
    return 0;
}

void swap(int &x, int &y)
{
    int tmp;
    tmp = x;
    x = y;
    y = tmp;
}