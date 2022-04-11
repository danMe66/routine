/**
 * @file classes-object-test-1.cpp
 * @author your name (you@domain.com)
 * @brief 类和对象
 * @version 0.1
 * @date 2022-04-11
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

double mianji(int a, int b);
class ZhiXiang
{
public:
    //变量
    int chang;
    int kuan;
    int gao;

    // 方法
    double mianji(int chang, int kuan);

    // 类成员函数
    double tiji(void)
    {
        return chang * kuan * gao;
    }

    // 外部成员函数声明
    double tiji_p(void);
};
// 外部实现类成员函数
double ZhiXiang::tiji_p(void)
{
    return chang * kuan * gao;
}

int main()
{
    int chang = 12;
    int kuan = 10;
    int gao = 2;
    double mj = mianji(chang, kuan);
    cout << "面积的值等于：" << mj << endl;

    ZhiXiang zhiXiang;
    zhiXiang.chang = chang;
    zhiXiang.kuan = kuan;
    zhiXiang.gao = gao;
    double tj = zhiXiang.tiji();
    cout << "体积的值等于：" << tj << endl;

    double tj_p = zhiXiang.tiji_p();
    cout << "[外部实现类成员函数]体积的值等于：" << tj_p << endl;
    return 0;
}

// 方法
double mianji(int chang, int kuan)
{
    return chang * kuan;
}