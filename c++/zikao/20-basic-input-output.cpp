/**
 * @file 20-basic-input-output.cpp
 * @author your name (you@domain.com)
 * @brief 基本的输入输出
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// C++ 的 I/O 发生在流中，流是字节序列。
// 如果字节流是从设备（如键盘、磁盘驱动器、网络连接等）流向内存，这叫做输入操作。
// 如果字节流是从内存流向设备（如显示屏、打印机、磁盘驱动器、网络连接等），这叫做输出操作。
// I/O 库头文件
// <iostream>:该文件定义了 cin、cout、cerr 和 clog 对象，分别对应于标准输入流、标准输出流、非缓冲标准错误流和缓冲标准错误流。
// <iomanip>:该文件通过所谓的参数化的流操纵器（比如 setw 和 setprecision），来声明对执行标准化 I/O 有用的服务。
// <fstream>:该文件为用户控制的文件处理声明服务。

// 预定义的对象 cout 是 iostream 类的一个实例。cout 对象"连接"到标准输出设备，通常是显示屏。cout 是与流插入运算符 << 结合使用的

#include <iostream>

using namespace std;

int main()
{
    char name[50];

    cout << "--------------- 标准输出流（cout） ---------------" << endl;
    cout << "请输入您的名称： " << endl;

    cout << "--------------- 标准输入流（cin） ---------------" << endl;
    cin >> name;
    cout << "您的名称是： " << name << endl;

    char str[] = "Unable to read....";

    cout << "--------------- 标准错误流（cerr） ---------------" << endl;
    cerr << "Error message : " << str << endl;

    cout << "--------------- 标准日志流（clog） ---------------" << endl;

    char clogstr[] = "Unable to read....";

    clog << "Error message : " << str << endl;
}
