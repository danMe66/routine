// 修饰符类型
/**
 * @brief 
 * c++ 允许在 char、int 和 double 数据类型前放置修饰符。修饰符用于改变基本类型的含义，所以它更能满足各种情境的需求。
 * 下面列出了数据类型修饰符：
 * signed 
 * unsigned
 * long
 * short
 * 
 * 
 */


#include <iostream>
using namespace std;
 
/* 
 * 这个程序演示了有符号整数和无符号整数之间的差别
*/
int main()
{
   short int i;           // 有符号短整数
   short unsigned int j;  // 无符号短整数
 
   j = 50000;
 
   i = j;
   cout << i << " " << j;
//  结果：-15536 50000

   return 0;
}
