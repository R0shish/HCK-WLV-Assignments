#include <pthread.h>
#include <stdio.h>

void *threadOne(void *p)
{
    int i;
    for (i = 1; i <= 200; i++)
        printf("%d\n", i);
}
void *threadTwo(void *p)
{
    int i;
    for (i = 201; i <= 400; i++)
        printf("%d\n", i);
}
void *threadThree(void *p)
{
    int i;
    for (i = 401; i <= 600; i++)
        printf("%d\n", i);
}
void *threadFour(void *p)
{
    int i;
    for (i = 601; i <= 800; i++)
        printf("%d\n", i);
}
void *threadFive(void *p)
{
    int i;
    for (i = 801; i <= 1000; i++)
        printf("%d\n", i);
}

void main()
{
    pthread_t thrID1, thrID2, thrID3, thrID4, thrID5;
    pthread_create(&thrID1, NULL, threadOne, NULL);
    pthread_create(&thrID2, NULL, threadTwo, NULL);
    pthread_create(&thrID3, NULL, threadThree, NULL);
    pthread_create(&thrID4, NULL, threadFour, NULL);
    pthread_create(&thrID5, NULL, threadFive, NULL);
    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
    pthread_join(thrID3, NULL);
    pthread_join(thrID4, NULL);
    pthread_join(thrID5, NULL);
}