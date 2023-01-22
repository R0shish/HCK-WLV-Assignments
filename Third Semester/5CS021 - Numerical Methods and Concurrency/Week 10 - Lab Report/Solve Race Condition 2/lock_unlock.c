#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
int counter = 0;
pthread_mutex_t mutex;
void *threadOne(void *p)
{
    pthread_mutex_lock(&mutex);
    int i;
    int temp;
    for (i = 1; i <= 3; i++)
    {
        temp = counter;
        sleep(1);
        counter = temp + 1;
    }
    pthread_mutex_unlock(&mutex);
}
void *threadTwo(void *p)
{
    pthread_mutex_lock(&mutex);
    int i;
    int temp;
    for (i = 1; i <= 3; i++)
    {
        temp = counter;
        sleep(1);
        counter = temp - 1;
    }
    pthread_mutex_unlock(&mutex);
}
void main()
{
    pthread_mutex_init(&mutex, NULL);
    pthread_t thrID1, thrID2;
    pthread_create(&thrID1, NULL, threadOne, NULL);
    pthread_create(&thrID2, NULL, threadTwo, NULL);

    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
    printf("counter = %d\n", counter);
    pthread_mutex_destroy(&mutex);
}