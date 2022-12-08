// Expected Output
// A
// B B
// C C C
// D D D D
// E E E E E

#include <stdio.h>

int main()
{
    char character[6] = {'A', 'B', 'C', 'D', 'E'};
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            printf("%c", character[i]);
        }
        printf("\n");
    }
    return 0;
}