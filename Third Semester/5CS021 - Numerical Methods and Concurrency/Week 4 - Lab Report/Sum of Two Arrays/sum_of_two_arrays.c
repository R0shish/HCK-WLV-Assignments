#include <stdio.h>
#include <stdlib.h>

void take_input(int **arr, int *arr_size, char text[]);

int main()
{
    int arr1_size, arr2_size, i;
    int *arr1, *arr2;

    take_input(&arr1, &arr1_size, "first");
    take_input(&arr2, &arr2_size, "second");

    int arr3_size = arr1_size > arr2_size ? arr1_size : arr2_size;
    int *arr3 = (int *)malloc(arr3_size * sizeof(int));

    for (i = 0; i < arr3_size; i++)
    {
        arr3[i] = arr1[i] + arr2[i];
    }

    for (i = 0; i < arr3_size; i++)
    {
        printf("%d ", arr3[i]);
    }

    printf("\n");

    free(arr1);
    free(arr2);
    free(arr3);
    return 0;
}

void take_input(int **arr, int *arr_size, char text[])
{
    int i;
    printf("How many elements do you want in the %s array? ", text);
    scanf("%d", arr_size);

    *arr = (int *)malloc(*arr_size * sizeof(int));

    for (i = 0; i < *arr_size; i++)
    {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &(*arr)[i]);
    }
}
