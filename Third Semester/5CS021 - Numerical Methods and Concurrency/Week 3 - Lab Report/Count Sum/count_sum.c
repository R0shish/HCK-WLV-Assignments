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

    int sum = 0;
    for (int i = 0; i < arr_size; i++)
    {
        if (arr[i] % 5 == 0 && arr[i] % 2 != 0 && arr[i] % 3 != 0)
            sum += arr[i];
    }
    printf("The sum is %d.\n", sum);
    return 0;
}