#include <stdio.h>

int check_perfect_number(int num)
{
    int result = 0;
    for (int i = 0; i < num; i++)
    {
        if (num % i == 0)
        {
            result += i;
        }
    }
    return (result == num);
}

int check_armstrong_number(int num)
{
    int result = 0;
    int temp = num;
    int digit;
    while (temp > 0)
    {
        digit = temp % 10;
        result += (digit * digit * digit);
        temp /= 10;
    }
    return (num == result);
}

int main()
{
    int perfectNumber = 6;
    if (check_perfect_number(perfectNumber) == 1)
        printf("The given number is a perfect number.\n");
    else
        printf("The given number is not a perfect number.\n");

    int armstrongNumber = 371;
    if (check_armstrong_number(armstrongNumber) == 1)
        printf("The given number is an armstrong number.\n");
    else
        printf("The given number is not an armstrong number.\n");
}
