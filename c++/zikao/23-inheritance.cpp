/**
 * @file 23-inheritance.cpp
 * @author your name (you@domain.com)
 * @brief 继承
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// 当创建一个类时，您不需要重新编写新的数据成员和成员函数，
// 只需指定新建的类继承了一个已有的类的成员即可。
// 这个已有的类称为基类，新建的类称为派生类。

// 一个派生类继承了所有的基类方法，但下列情况除外：
// 基类的构造函数、析构函数和拷贝构造函数。
// 基类的重载运算符。
// 基类的友元函数。

#include <iostream>

using namespace std;

class Animal
{
private:
    int a = 1;
    int b = 2;

public:
    int c = 3;
    int d = 4;
};

class Animal1 : public Animal
{
public:
    int getSum()
    {
        // int privateSum = a + b;
        int publicSum = c + d;
        return publicSum;
    }
};

int main()
{
    Animal1 animal1;

    cout << "小猫：" << animal1.getSum() << endl;

    return 0;
}
