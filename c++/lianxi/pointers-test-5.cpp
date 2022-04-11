/**
 * @file pointers-test-5.cpp
 * @author your name (you@domain.com)
 * @brief 从函数返回指针
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

int *get_address(int a);
int main()
{
    int a = 100;
    cout << "a的指针为：" << get_address(a) << endl;
    cout << "a的指针对应的值为：" << *get_address(a) << endl;
    return 0;
}

int *get_address(int a)
{
    int *address = &a;
    return address;
}