#include <stdio.h>
#include <pthread.h>
int count = 0;
pthread_mutex_t mutex;

void *fun(void *arg)
{
    pthread_mutex_lock(&mutex);
    count++;
    printf("Thread%d has started\n", count);
    for (int i = 1; i <= 1000000; i++)
    {
    }
    printf("Thread %d has finished\n", count);
    pthread_mutex_unlock(&mutex);
}

void main()
{
    pthread_mutex_init(&mutex, NULL);
    pthread_t thread1, thread2;
    pthread_create(&thread1, NULL, fun, NULL);
    pthread_create(&thread2, NULL, fun, NULL);
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    pthread_mutex_destroy(&mutex);
}
