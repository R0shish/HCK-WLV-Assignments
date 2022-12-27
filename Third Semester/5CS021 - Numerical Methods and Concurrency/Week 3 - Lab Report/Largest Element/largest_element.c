#include <stdio.h>

int main()
{
    int arr_size;
    printf("Enter the number of elements you want to enter: ");
    scanf("%d", &arr_size);
    int arr[arr_size];

    for (int i = 0; i < arr_size; i++)
    {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    int max = arr[0];
    for (int i = 1; i < arr_size; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    printf("%d is the largest element in the array.\n", max);
    return 0;
}