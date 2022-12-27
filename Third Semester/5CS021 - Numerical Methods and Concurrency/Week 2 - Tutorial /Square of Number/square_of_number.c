#include <stdio.h>

int square(int num)
{
    return num * num;
}

int main()
{
    int n = 10;
    printf("%d", square(n));
    return 0;
}