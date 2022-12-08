// Expected output :
// When n = 100
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91

#include <stdio.h>

int main()
{
    int n;
    int num = 1;
    printf("Enter the number: ");
    scanf("%d", &n);
    for (int i = 0; num <= n; i++)
    {
        printf("%d ", num);
        num += i + 2;
    }
    return 0;
}