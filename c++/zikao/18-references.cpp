/**
 * @file 18-references.cpp
 * @author your name (you@domain.com)
 * @brief 引用
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */
// 引用变量是一个别名，也就是说，它是某个已存在变量的另一个名字。一旦把引用初始化为某个变量，就可以使用该引用名称或变量名称来指向变量。
// 引用 vs 指针
// 引用很容易与指针混淆，它们之间有三个主要的不同：
// 1：不存在空引用。引用必须连接到一块合法的内存。
// 2：一旦引用被初始化为一个对象，就不能被指向到另一个对象。指针可以在任何时候指向到另一个对象。
// 3：引用必须在创建时被初始化。指针可以在任何时间被初始化。

#include <iostream>

using namespace std;

double vals[] = {10.1, 12.6, 33.1, 24.1, 50.0};

double &setValues(int i)
{
    double &ref = vals[i];
    return ref; // 返回第 i 个元素的引用，ref 是一个引用变量，ref 引用 vals[i]
}


// 函数声明
void swap(int &x, int &y);
int main()
{
    // 声明简单的变量
    int i;
    double d;

    // 声明引用变量
    int &r = i;
    double &s = d;

    // & 读作引用。
    // 第一个声明可以读作 "r 是一个初始化为 i 的整型引用"，
    // 第二个声明可以读作 "s 是一个初始化为 d 的 double 型引用"。

    i = 5;
    cout << "Value of i : " << i << endl;
    cout << "Value of i reference : " << r << endl;

    d = 11.7;
    cout << "Value of d : " << d << endl;
    cout << "Value of d reference : " << s << endl;

    cout << "--------------- 把引用作为参数 ---------------" << endl;
    // 把引用作为参数
    int a = 10;
    int b = 15;
    cout << "交换前的a等于" << a << endl;
    cout << "交换前的b等于" << b << endl;
    swap(a, b);
    cout << "交换后的a等于" << a << endl;
    cout << "交换后的b等于" << b << endl;

    cout << "--------------- 把引用作为返回值 ---------------" << endl;
    // 把引用作为返回值
    // 过使用引用来替代指针，会使 C++ 程序更容易阅读和维护。
    // C++ 函数可以返回一个引用，方式与返回一个指针类似。
    // 当函数返回一个引用时，则返回一个指向返回值的隐式指针。

    cout << "改变前的值" << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << "vals[" << i << "] = ";
        cout << vals[i] << endl;
    }

    setValues(1) = 20.23; // 改变第 2 个元素
    setValues(3) = 70.8;  // 改变第 4 个元素

    cout << "改变后的值" << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << "vals[" << i << "] = ";
        cout << vals[i] << endl;
    }
    return 0;
}

void swap(int &x, int &y)
{
    int tmp;
    tmp = x;
    x = y;
    y = tmp;
    return;
}