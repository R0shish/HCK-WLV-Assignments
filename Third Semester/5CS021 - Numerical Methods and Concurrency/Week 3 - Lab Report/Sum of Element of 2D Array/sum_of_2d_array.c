#include <stdio.h>

int main()
{
    int arr_1[3][3] = {{3, 6, 8}, {1, 4, 2}, {5, 9, 7}};
    int arr_2[3][3] = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
    int ROW_SIZE = 3;
    int COL_SIZE = 3;

    for (int col = 0; col < COL_SIZE; col++)
    {
        for (int row = 0; row < ROW_SIZE; row++)
        {
            printf("%d ", arr_1[row][col] + arr_2[row][col]);
        }
        printf("\n");
    }
    return 0;
}