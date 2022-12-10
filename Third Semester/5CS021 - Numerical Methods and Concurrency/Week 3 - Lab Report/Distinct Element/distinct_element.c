#include <stdio.h>

int main()
{
    int arr[] = {1, 2, 4, 8, 4, 2, 4, 9, 6};
    int arr_size = sizeof(arr) / sizeof(int);
    for (int i = 0; i < arr_size; i++)
    {
        int j;
        for (j = i + 1; j < arr_size; j++)
        {
            if (arr[i] == arr[j])
            {
                break;
            }
        }
        if (j == arr_size)
            printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}