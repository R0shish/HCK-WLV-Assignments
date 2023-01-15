#include <stdio.h>

#include <pthread.h>

void *threadOne(void *p)
{
    int i, c;
    int nstart = 1, nfinish = 10000;
    printf("threadOne : Prime numbers between %d and %d are :\n",
           nstart, nfinish);
    for (i = nstart; i <= nfinish; i++)
    {
        for (c = 2; c <= i - 1; c++)
        {
            if (i % c == 0)
                break;
        }
        if (c == i)
            printf("threadOne : %d\n", i);
    }
    return 0;
}

void *threadTwo(void *p)
{
    int i, c;
    int nstart = 10001, nfinish = 20000;
    for (i = nstart; i <= nfinish; i++)
    {
        for (c = 2; c <= i - 1; c++)
        {
            if (i % c == 0)

                break;
        }
        if (c == i)
            printf("threadTwo : %d\n", i);
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