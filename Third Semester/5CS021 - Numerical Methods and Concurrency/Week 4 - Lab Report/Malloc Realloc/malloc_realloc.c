#include <stdio.h>
#include <stdlib.h>

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

    printf("Original array: ");
    for (int i = 0; i < arr_size; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int add_size;
    printf("How many elements do you want to add? ");
    scanf("%d", &add_size);

    arr = (int *)realloc(arr, (arr_size + add_size) * sizeof(int));

    for (int i = arr_size; i < arr_size + add_size; i++)
    {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("New array: ");
    for (int i = 0; i < arr_size + add_size; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    free(arr);
    return 0;
}
