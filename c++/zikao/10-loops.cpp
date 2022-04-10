/**
 * @file 10-loops.CPP
 * @author your name (you@domain.com)
 * @brief 循环
 * @version 0.1
 * @date 2022-04-09
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
using namespace std;
 
int whilemain();
int formain();
int dowhilemain();

int main ()
{
    cout << "--------------- while循环 ---------------"<< endl;
    whilemain();
    cout << "--------------- for循环 ---------------"<< endl;
    formain();
    cout << "--------------- do_while循环 ---------------"<< endl;
    dowhilemain();
    
   return 0;
}

// while循环
#include <iostream>
using namespace std;
 
int whilemain ()
{
   // 局部变量声明
   int a = 10;

   // while 循环执行
   while( a < 20 )
   {
       cout << "a 的值：" << a << endl;
       a++;
   }
 
   return 0;
}

// for循环

#include <iostream>
using namespace std;
 
int formain ()
{
   // for 循环执行
   for( int a = 10; a < 20; a = a + 1 )
   {
       cout << "a 的值：" << a << endl;
   }
 
   return 0;
}


// dowhile循环
// 条件表达式出现在循环的尾部，所以循环中的 statement(s) 会在条件被测试之前至少执行一次。
// 如果条件为真，控制流会跳转回上面的 do，然后重新执行循环中的 statement(s)。这个过程会不断重复，直到给定条件变为假为止。
#include <iostream>
using namespace std;
 
int dowhilemain ()
{
   // 局部变量声明
   int a = 10;

   // do 循环执行
   do
   {
       cout << "a 的值：" << a << endl;
       a = a + 1;
   }while( a < 20 );
 
   return 0;
}
