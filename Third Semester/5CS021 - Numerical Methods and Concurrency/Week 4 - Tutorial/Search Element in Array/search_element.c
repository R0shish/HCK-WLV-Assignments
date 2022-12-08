#include <stdio.h>

int main()
{
    int arr[5] = {1, 2, 3, 4, 5};
    int num = 5, found = 0;
    int *p = &arr[0];

    for (int i = 0; i < sizeof(arr) / sizeof(int); i++, p++)
    {
        if (*p == num)
        {
            found = 1;
        }
    }
    if (found)
    {
        printf("Found!\n");
    }
    else
    {
        printf("Not Found!\n");
    }
    return 0;
}
