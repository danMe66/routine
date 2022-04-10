/**
 * @file 8-storage-classes.cpp
 * @author liudandan
 * @brief 
 * @version 0.1
 * @date 2022-04-09
 * 
 * @copyright Copyright (c) 2022
 * 
 * 存储类
 * 存储类定义 C++ 程序中变量/函数的范围（可见性）和生命周期。
 * 这些说明符放置在它们所修饰的类型之前。
 */

// auto 存储类
/**
 * @brief 
 * auto f=3.14;      //double
 * auto s("hello");  //const char*
 * auto z = new auto(9); // int*
 * auto x1 = 5, x2 = 5.0, x3='r';//错误，必须是初始化为同一类型
 */