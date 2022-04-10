/**
 * @file 22-classes-objects.cpp
 * @author your name (you@domain.com)
 * @brief 类 & 对象 默写代码测试
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>

using namespace std;

class Box
{
    // 变量声明
public:
    double chang;
    double kuan;
    double gao;

    // 成员函数声明
    double get(void);
    void set(double changdu, double kuandu, double gaodu);
};

double Box::get(void)
{
    return chang * kuan * gao;
}

void Box::set(double c, double k, double g)
{
    chang = c;
    kuan = k;
    gao = g;
}

int main()
{
    Box box;

    box.chang = 12.0;
    box.kuan = 10;
    box.gao = 2;

    box.set(box.chang, box.kuan, box.gao);
    double mianji = box.get();
    cout << "长方体的面积等于：" << mianji << endl;

    return 0;
}