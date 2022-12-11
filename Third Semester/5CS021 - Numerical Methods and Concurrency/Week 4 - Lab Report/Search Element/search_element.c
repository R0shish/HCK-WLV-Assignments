#include <stdio.h>

int main()
{
    int arr[] = {2, 4, 7, 3, 1, 8, 0};
    int arr_size = sizeof(arr) / sizeof(int);
    int index;

    printf("Enter the index: ");
    scanf("%d", &index);

    printf("The element at %d index is %d.\n", index, arr[index]);
    return 0;
}