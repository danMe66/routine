/**
 * @file copy-constructo-test-1.cpp
 * @author your name (you@domain.com)
 * @brief 拷贝构造函数
 * @version 0.1
 * @date 2022-04-12
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>

using namespace std;

class Stu
{
public:
    int age;
    // 简单的带参函数
    Stu(int age);
    // 拷贝构造函数
    Stu(const Stu &obj);
    // 类方法
    int getAge(void);
    // 析构函数
    ~Stu();

private:
    int *ptr;
};

Stu::Stu(int age)
{
    cout << "构造函数调用" << endl;
    cout << "年龄等于：" << age << endl;
    ptr = new int;
    *ptr = age;
}

int Stu::getAge(void)
{
    return *ptr;
}

Stu::Stu(const Stu &obj)
{
    cout << "obj的值被拷贝：" << *obj.ptr << endl;
    ptr = new int;
    *ptr = *obj.ptr; // 拷贝值
}

Stu::~Stu()
{
    cout << "析构函数调用" << endl;
    delete ptr;
}

void display(Stu obj)
{
    cout << "age 的值等于 : " << obj.getAge() << endl;
}

int main()
{
    Stu stu(18);
    display(stu);
    return 0;
}