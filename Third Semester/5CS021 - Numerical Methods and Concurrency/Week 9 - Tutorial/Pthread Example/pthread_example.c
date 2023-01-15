#include <stdio.h>
#include <pthread.h>

void *threadOne(void *p)
{
    for (int i = 0; i < 1000; i++)
    {
        printf("Thread One: i=%d\n", i);
    }
}

void *threadTwo(void *p)
{
    for (int i = 0; i < 1000; i++)
    {
        printf("Thread Two: i=%d\n", i);
    }
}

int main()
{
    pthread_t thrID1, thrID2;
    pthread_create(&thrID1, NULL, threadOne, NULL);
    pthread_create(&thrID2, NULL, threadTwo, NULL);
    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
    return 0;
}