#include <stdio.h>

void swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
    printf("After : a = %d, b = %d\n", a, b);
}

void swap_without_temp(int *a, int *b)
{
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
}

int main()
{
    int a = 10, b = 20;
    printf("Before : a = %d, b = %d\n", a, b);
    swap(a, b);
    return 0;
}