#include <stdio.h>

void equation(double a, double b, double c, double d,
              double e, double f)
{
    double x, y;
    x = (f * b - e * c) / (b * d - a * e);
    y = (c - a * x) / b;

    printf("The point where the two lines cross each other is (%g, %g)", x, y);
}

int main()
{
    equation(10, 5, 60, 2, 15, 40);
    return 0;
}