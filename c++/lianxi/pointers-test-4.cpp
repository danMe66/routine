/**
 * @file pointers-test-4.cpp
 * @author your name (you@domain.com)
 * @brief 传递指针给函数
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

// 定义参数为指针的函数
int pointer_sum(int *arr, int size);
int mian()
{
    int a[3] = {1, 2, 3};
    int b = 3;

    int sum = pointer_sum(a, b);
    cout << "a[2]元素相加等于：" << sum << endl;
    return 0;
}

// 函数实现
int pointer_sum(int *arr, int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += arr[i];
    }
    return sum;
}