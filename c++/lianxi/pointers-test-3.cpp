/**
 * @file pointers-test-3.cpp
 * @author your name (you@domain.com)
 * @brief 指向指针的指针-指针链
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>

using namespace std;

int main()
{
    int var;
    int *address;
    int **p_address;

    var = 3000;
    address = &var;
    p_address = &address;
    cout << "address 的指针地址: " << address << endl;
    cout << "address 的指针地址对应的值: " << *address << endl;
    cout << "p_address: " << p_address << endl;
    cout << "p_address 的指针地址对应的值: " << **p_address << endl;

    return 0;
}