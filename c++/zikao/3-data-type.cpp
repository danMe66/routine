
#include <iostream>
using namespace std;
int main()
{
    // typedef 声明
    typedef int feet;
    feet age = 12;
    std::cout << age << std::endl;

    // 枚举类型
    enum sex_enum
    {
        man,
        woman
    } sex;

    enum color
    {
        red,
        green,
        blue
    } c;
    c = blue;
    // 默认情况下，第一个名称的值为 0，第二个名称的值为 1，第三个名称的值为 2，以此类推。但是，您也可以给名称赋予一个特殊的值，只需要添加一个初始值即可。
    return 0;
}
