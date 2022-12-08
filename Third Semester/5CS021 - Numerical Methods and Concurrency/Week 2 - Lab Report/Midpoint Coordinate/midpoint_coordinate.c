#include <stdio.h>

void midpoint_coordinate(int x1, int x2, int y1, int y2)
{
    int xmid, ymid;
    xmid = (x1 + x2) / 2;
    ymid = (y1 + y2) / 2;

    printf("The midpoint coordinate of the line is (%d,%d)\n", xmid, ymid);
}
int main()
{
    int x1 = 20, x2 = 30;
    int y1 = 30, y2 = 40;
    midpoint_coordinate(x1, x2, y1, y2);
    return 0;
}