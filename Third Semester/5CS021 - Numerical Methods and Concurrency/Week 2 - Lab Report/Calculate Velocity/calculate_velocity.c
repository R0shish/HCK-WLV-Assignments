#include <stdio.h>
#include <math.h>

float velocityCalc(float v, float u, float a, float t)
{
    if (isnan(v))
    {
        v = u + a * t;
        return v;
    }
    else if (isnan(u))
    {
        u = v - a * t;
        return u;
    }
    else if (isnan(a))
    {
        a = (v - u) / t;
        return a;
    }
    else if (isnan(t))
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
    v = NAN, u = 20, a = 50, t = 20;
    // v = 40, u = 20, a = 50, t = NAN;
    // v = 40, u = 30, a = NAN, t = 60;

    printf("The value of unknown variable is %g.\n", velocityCalc(v, u, a, t));
    return 0;
}