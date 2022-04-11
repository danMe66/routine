/**
 * @file classes-constructor-destructor-test-1.cpp
 * @author your name (you@domain.com)
 * @brief 构造函数&析构函数
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>

using namespace std;

class Box
{
public:
    int chang;
    int kuan;
    int gao;
    Box();  //构造函数
    ~Box(); //析构函数

private:
    int a;
};

// 成员函数定义-构造函数也是类成员函数
Box ::Box(void)
{
    cout << "构造函数被执行调用" << endl;
}

// 成员函数定义-析构函数也是类成员函数
Box ::~Box()
{
    cout << "析构函数被执行调用" << endl;
}

int main()
{
    Box box;
    box.chang = 100;
    cout << "box.chang等于：" << box.chang << endl;
    return 0;
}