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