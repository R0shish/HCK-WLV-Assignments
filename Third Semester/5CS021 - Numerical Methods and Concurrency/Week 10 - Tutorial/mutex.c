#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void *func1();
void *func2();
int shared = 1;
pthread_mutex_t lock;

int main()
{
    pthread_mutex_init(&lock, NULL);
    pthread_t thrID1, thrID2;
    pthread_create(&thrID1, NULL, func1, NULL);
    pthread_create(&thrID2, NULL, func2, NULL);
    pthread_join(thrID1, NULL);
    pthread_join(thrID2, NULL);
    printf("The final value of shared is %d.\n", shared);
    return 0;
}

void *func1()
{
    int x;
    printf("Thread1 trying to acquire lock\n");
    pthread_mutex_lock(&lock);
    printf("Thread1 acquired lock\n");
    x = shared;
    printf("Thread1 reads the value of shared variable as %d.\n", x);
    x++;
    printf("Local updation by Thread1: %d\n", x);
    sleep(1);
    shared = x;
    printf("Value of shared variable updated by Thread1 is: %d\n", shared);
    pthread_mutex_unlock(&lock);
    printf("Thread1 released the lock\n");
};

void *func2()
{
    int y;
    printf("Thread2 trying to acquire lock\n");
    pthread_mutex_lock(&lock);
    printf("Thread2 acquired lock\n");
    y = shared;
    printf("Thread2 reads the value of shared variable as %d.\n", y);
    y--;
    printf("Local updation by Thread2: %d\n", y);
    sleep(1);
    shared = y;
    printf("Value of shared variable updated by Thread2 is: %d\n", shared);
    pthread_mutex_unlock(&lock);
    printf("Thread2 released the lock\n");
};
