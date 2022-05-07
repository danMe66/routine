#include <stdio.h>

int main()
{
    short int a = 1;
    int b, c = 99;

    short d = 1;
    short e, f = 99;

    int short_length = sizeof(a);
    int int_length = sizeof(b);

    printf("a=1的length:%d \n", a);
    printf("b=99的length:%d \n", b);
    return 0;
}