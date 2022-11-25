#include <stdio.h>

int cube(int num)
{
    return num * num * num;
}
int main()
{
    int n = 5;
    printf("%d\n", cube(n));
    return 0;
}