#include <stdio.h>

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6};
    int sum = 0;
    int *p = &arr[0];
    for (int i = 0; i < sizeof(arr) / sizeof(int); i++, p++)
    {
        sum += *p;
    }
    printf("%d\n", sum);
    return 0;
}