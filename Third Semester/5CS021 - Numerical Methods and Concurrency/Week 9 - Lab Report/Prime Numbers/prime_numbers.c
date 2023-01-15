#include <stdio.h>
#include <pthread.h>

void *threadOne(void *p)
{
    int i, c;
    int nstart = 1, nfinish = 250;
    printf("Prime numbers between %d and %d are :\n", nstart, nfinish);
    for (i = nstart; i <= nfinish; i++)
    {
        for (c = 2; c <= i - 1; c++)
        {
            if (i % c == 0)
                break;
        }
        if (c == i)
            printf("%d\n", i);
    }
    return 0;
}

void *threadTwo(void *p)
{
    int i, c;
    int nstart = 251, nfinish = 500;
    for (i = nstart; i <= nfinish; i++)
    {
        for (c = 2; c <= i - 1; c++)
        {
            if (i % c == 0)
                break;
        }
        if (c == i)
            printf("%d\n", i);
    }
    return 0;
}

void main()
{
    pthread_t thrID1, thrID2;
    pthread_create(&thrID1, NULL, threadOne, NULL);
    pthread_create(&thrID2, NULL, threadTwo, NULL);
    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
}