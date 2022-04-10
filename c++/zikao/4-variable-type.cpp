// 变量类型
#include <iostream>

// 函数声明
int func();

int main()
{
    // 变量的名称可以由字母、数字和下划线字符组成。
    // 它必须以字母或下划线开头。大写字母和小写字母是不同的，
    // 因为 C++ 是大小写敏感的。

    // bool:存储值 true 或 false。
    // char:通常是一个字符（八位）。这是一个整数类型。
    // int:对机器而言，整数的最自然的大小。
    // float:单精度浮点值。单精度是这样的格式，1位符号，8位指数，23位小数。
    // double:双精度浮点值。双精度是1位符号，11位指数，52位小数。
    // void:表示类型的缺失。
    // wchar_t:宽字符类型。

    // 变量定义
    int i, j, k;
    char c, ch;
    float f, salary;
    double d;
    bool b;
    std::cout << f << std::endl;
    std::cout << b << std::endl;

    // 初始化变量值
    // 不带初始化的定义：带有静态存储持续时间的变量会被隐式初始化为 NULL（所有字节的值都是 0），
    // 其他所有变量的初始值是未定义的。
    int dd = 3, ff = 5;
    char cc = 'c';
    float fll = 12.40;
    std::cout << dd << std::endl;
    std::cout << ff << std::endl;
    std::cout << cc << std::endl;
    std::cout << fll << std::endl;

    // 变量声明
    // 可以使用 extern 关键字在任何地方声明一个变量。
    // 虽然可以在 C++ 程序中多次声明一个变量，
    // 但变量只能在某个文件、函数或代码块中被定义一次。
    extern int a1, a2;
    a1 = 12;
    a2 = 22;
    std::cout << a1 << std::endl;

    // 函数调用
    int i1 = func();
    return i1;
}

// 函数定义
int func()
{
    return 0;
}