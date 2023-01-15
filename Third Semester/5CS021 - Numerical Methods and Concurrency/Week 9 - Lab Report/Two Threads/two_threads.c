#include <pthread.h>
#include <stdio.h>

void *threadOne(void *p)
{
    for (int i = 1; i <= 500; i++)
        printf("%d\n", i);
}

void *threadTwo(void *p)
{
    for (int i = 501; i <= 1000; i++)
        printf("%d\n", i);
}
void main()
{
    pthread_t thrID1, thrID2;
    pthread_create(&thrID1, NULL, threadOne, NULL);
    pthread_create(&thrID2, NULL, threadTwo, NULL);
    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
}