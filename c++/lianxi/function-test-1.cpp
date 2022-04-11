#include <iostream>

using namespace std;

//函数声明

int max(int a, int b);
int main()
{
    int a = 1;
    int b = 2;
    // 函数调用
    int max_num = max(a, b);
    cout << "最大值：" << max_num << endl;
    return 0;
}

// 函数实现
int max(int a, int b)
{
    if (a > b)
    {
        return a;
    }
    else if (a == b)
    {
        return 0;
    }
    else
    {
        return b;
    }
}