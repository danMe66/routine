/**
 * @file 14-arrays.cpp
 * @author your name (you@domain.com)
 * @brief 数组
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// 数组可以存储一个固定大小的相同类型元素的顺序集合。数组是用来存储一系列数据，但它往往被认为是一系列相同类型的变量。
// 数组中的特定元素可以通过索引访问。
// 所有的数组都是由连续的内存位置组成。最低的地址对应第一个元素，最高的地址对应最后一个元素。

#include <iostream>
using namespace std;

#include <iomanip>
using std::setw;

int main()
{
    int n[10]; // n 是一个包含 10 个整数的数组

    // 初始化数组元素
    for (int i = 0; i < 10; i++)
    {
        n[i] = i + 100; // 设置元素 i 为 i + 100
    }
    cout << "Element" << setw(13) << "Value" << endl;

    // 输出数组中每个元素的值
    for (int j = 0; j < 10; j++)
    {
        cout << setw(7) << j << setw(13) << n[j] << endl;
    }
    // 声明数组
    double balance[10];
    // 初始化数组

    double balances[5] = {12.3, 13.3, 13.0, 12.9, 33.0};
    double balances_big[] = {1000.0, 2.0, 3.4, 7.0, 50.0};

    cout << "--------------- 多维数组 ---------------" << endl;
    // 多维数组
    // 一个带有 5 行 2 列的数组
    int a[5][2] = {{0, 0}, {1, 2}, {2, 4}, {3, 6}, {4, 8}};

    // 输出数组中每个元素的值
    for (int i = 0; i < 5; i++)
        for (int j = 0; j < 2; j++)
        {
            cout << "a[" << i << "][" << j << "]: ";
            cout << a[i][j] << endl;
        }

    cout << "--------------- 指向数组的指针 ---------------" << endl;
    // 指向数组的指针
    double *p;
    p = balances_big;
    cout << p << endl;

    return 0;
}