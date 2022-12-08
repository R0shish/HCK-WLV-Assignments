#include <stdio.h>

void prime_or_not(int num)
{
    int count = 0;
    for (int i = 1; i <= num; i++)
    {
        if (num % i == 0)
            count++;
    }
    if (count <= 2)
        printf("The given number is prime.\n");
    else
        printf("The given number is not prime.\n");
}

int main()
{
    int n = 13;
    prime_or_not(n);
    return 0;
}