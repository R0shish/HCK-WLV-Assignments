#include <stdio.h>

int velocityCalc(int v, int u, int a, int t)
{
    if (v == 0)
    {
        v = u + a * t;
        return v;
    }
    else if (u == 0)
    {
        u = v - a * t;
        return u;
    }
    else if (a == 0)
    {
        a = (v - u) / t;
        return a;
    }
    else if (t == 0)
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
    int v, u, a, t;
    printf("Enter 0 for the unknown value\n");
    printf("Enter the value of v: ");
    scanf("%d", &v);
    printf("Enter the value of u: ");
    scanf("%d", &u);
    printf("Enter the value of a: ");
    scanf("%d", &a);
    printf("Enter the value of t: ");
    scanf("%d", &t);

    printf("The value of unknown variable is %d.\n", velocityCalc(v, u, a, t));
    return 0;
}