#include <stdio.h>

int main()
{
    int arr[] = {2, 5, 3, 10, 9, 6};
    int max = arr[0];
    for (int i = 1; i < sizeof(arr) / sizeof(int); i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    printf("%d is the largest element in the array.\n", max);
    return 0;
}