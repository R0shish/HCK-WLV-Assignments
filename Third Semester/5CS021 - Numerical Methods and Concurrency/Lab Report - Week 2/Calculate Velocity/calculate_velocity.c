#include <stdio.h>
#include <math.h>

int velocityCalc(int v, int u, int a, int t)
{
    if (isnan(v) || v == 0)
    {
        v = u + a * t;
        return v;
    }
    else if (isnan(u) || u == 0)
    {
        u = v - a * t;
        return u;
    }
    else if (isnan(a) || a == 0)
    {
        a = (v - u) / t;
        return a;
    }
    else if (isnan(t) || t == 0)
    {
        t = (v - u) / a;
        return t;
    }
    else
    {
        return 0;
    }
}

int main()
{
    float v, u, a, t;
    printf("Enter 0 for the unknown value\n");
    printf("Enter the value of v: ");
    scanf("%f", &v);
    printf("Enter the value of u: ");
    scanf("%f", &u);
    printf("Enter the value of a: ");
    scanf("%f", &a);
    printf("Enter the value of t: ");
    scanf("%f", &t);

    printf("The value of unknown variable is %d.\n", velocityCalc(v, u, a, t));
    return 0;
}