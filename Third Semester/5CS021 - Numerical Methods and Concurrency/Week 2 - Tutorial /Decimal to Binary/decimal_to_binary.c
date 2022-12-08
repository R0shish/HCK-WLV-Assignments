#include <stdio.h>

void decimal_to_binary(int decimal)
{
    int binary[32];
    int i = 0;
    while (decimal > 0)
    {
        binary[i] = decimal % 2;
        decimal = decimal / 2;
        i++;
    }
    for (int j = i - 1; j >= 0; j--)
    {
        printf("%d", binary[j]);
    }
    printf("\n");
}

int main()
{
    int d = 63;
    decimal_to_binary(d);
    return 0;
}