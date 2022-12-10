#include <stdio.h>

int main()
{
    int arr[] = {3, 5, 6, 7, 10, 15};
    int arr_size = sizeof(arr) / sizeof(int);
    int sum = 0;
    for (int i = 0; i < arr_size; i++)
    {
        if (arr[i] % 5 == 0 && arr[i] % 2 != 0 && arr[i] % 3 != 0)
            sum += arr[i];
    }
    printf("The sum is %d.\n", sum);
    return 0;
}