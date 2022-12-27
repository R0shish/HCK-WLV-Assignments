#include <stdio.h>

// Using Bitwise Operator
void odd_or_even_bitwise(int num)
{
    if (num & 1)
        printf("The number is odd.\n");
    else
        printf("The number is even.\n");
};

// Using Bitwise Operator
void odd_or_even(int num)
{
    if (num % 2 == 0)
        printf("The number is even.\n");
    else
        printf("The number is odd.\n");
};

int main()
{
    int num = 13;
    odd_or_even_bitwise(num);
    return 0;
}
