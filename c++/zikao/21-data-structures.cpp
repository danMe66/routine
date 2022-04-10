/**
 * @file 21-data-structures.cpp
 * @author your name (you@domain.com)
 * @brief 数据结构
 * @version 0.1
 * @date 2022-04-09
 *
 * @copyright Copyright (c) 2022
 *
 */

// C/C++ 数组允许定义可存储相同类型数据项的变量，
// 但是结构是 C++ 中另一种用户自定义的可用的数据类型，它允许您存储不同类型的数据项。

// 定义结构
// 为了定义结构，您必须使用 struct 语句。struct 语句定义了一个包含多个成员的新的数据类型，struct 语句的格式如下：

// struct type_name
// {
//     member_type1 member_name1;
//     member_type2 member_name2;
//     member_type3 member_name3;
// } object_names;

#include <iostream>
#include <cstring>

using namespace std;

// 什么一个结构体
struct Books
{
    int book_id;
    char name[50];
};

void printBook(struct Books book);
void printBooks(struct Books *book);
int main()
{
    // 定义结构体变量
    Books book;

    // 结构体赋值
    book.book_id = 1;
    strcpy(book.name, "语文");

    cout << "bookId：" << book.book_id << endl;
    cout << "bookName：" << book.name << endl;

    // 输出
    printBook(book);
    cout << "结构指针作为参数" << endl;
    printBooks(&book);

    // typedef 关键字
    return 0;
}

// 结构作为函数参数
void printBook(struct Books book)
{
    cout << "书 ID : " << book.book_id << endl;
    cout << "书名称 : " << book.name << endl;
}

// 该函数以结构指针作为参数
void printBooks(struct Books *book)
{
    cout << "书 ID : " << book->book_id << endl;
    cout << "书名称 : " << book->name << endl;
}