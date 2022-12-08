#include <stdio.h>

int main()
{
    int arr[] = {1, 2, 3, 4, 5};
    int *p = &arr[0];
    for (int i = 0; i < sizeof(arr) / sizeof(int); i++, p++)
    {
        printf("%d\n", *p);
    }
    return 0;
}