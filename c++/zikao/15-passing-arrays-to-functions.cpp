/**
 * @file 15-passing-arrays-to-functions.cpp
 * @author your name (you@domain.com)
 * @brief 传递数组给函数
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// 通过指定不带索引的数组名来传递一个指向数组的指针。
// C++ 传数组给一个函数，数组类型自动转换为指针类型，因而传的实际是地址。
#include <iostream>
using namespace std;

// 函数声明
double getAverage(int arr[], int size);

int main()
{
    // 带有 5 个元素的整型数组
    int balance[5] = {1000, 2, 3, 17, 50};
    double avg;

    // 传递一个指向数组的指针作为参数
    avg = getAverage(balance, 5);

    // 输出返回值
    cout << "平均值是：" << avg << endl;

    return 0;
}

double getAverage(int arr[], int size)
{
    int i, sum = 0;
    double avg;

    for (i = 0; i < size; ++i)
    {
        sum += arr[i];
    }

    avg = double(sum) / size;

    return avg;
}

void myFunction(int *param)
{
}
void myFunction(int param[10])
{
}
void myFunction(int param[])
{
}