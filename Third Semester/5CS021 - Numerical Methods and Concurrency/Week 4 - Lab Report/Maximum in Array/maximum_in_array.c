#include <stdio.h>
#include <stdlib.h>

int max_in_arr(int *arr, int arr_size);

int main()
{
    int arr_size;

    printf("How many elements do you want to enter? ");
    scanf("%d", &arr_size);

    int *arr = (int *)malloc(arr_size * sizeof(int));
    for (int i = 0; i < arr_size; i++)
    {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("The maximum in the array is %d.\n", max_in_arr(arr, arr_size));

    free(arr);
    return 0;
}

int max_in_arr(int *arr, int arr_size)
{
    int max, i;
    max = arr[0];
    for (i = 1; i < arr_size; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    return max;
}