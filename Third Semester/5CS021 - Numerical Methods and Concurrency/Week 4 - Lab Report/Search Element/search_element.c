#include <stdio.h>

int main()
{
    int arr[] = {2, 4, 7, 3, 1, 8, 0};
    int arr_size = sizeof(arr) / sizeof(int);
    int *p = &arr[0];
    int num;

    printf("Enter the number you want to search: ");
    scanf("%d", &num);

    for (int i = 0; i < sizeof(arr) / sizeof(int); i++, p++)
    {
        if (*p == num)
        {
            printf("Number found in the array!\n");
            return 0;
        }
    }
    printf("Number not found in the array!\n");
    return 0;
}