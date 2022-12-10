#include <stdio.h>

int main()
{
    int arr[] = {9, 8, 6, 7, 4, 5, 2, 1, 3};
    int arr_size = sizeof(arr) / sizeof(int);
    int temp;
    for (int i = 0; i < arr_size; i++)
    {
        for (int j = i + 1; j < arr_size; j++)
        {
            if (arr[i] > arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    for (int i = 0; i < arr_size; i++)
    {
        printf("%d ", arr[i]);
    }
    return 0;
}
