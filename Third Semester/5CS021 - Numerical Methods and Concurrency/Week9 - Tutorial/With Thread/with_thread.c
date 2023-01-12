#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

void *first(void *p)
{
    while (1)
    {
        sleep(1);
        printf("I am from 1st function \n");
    }
}

void second()
{
    while (1)
    {
        sleep(2);
        printf("I am from 2nd function \n");
    }
}

void main()
{
    pthread_t thread1;
    pthread_create(&thread1, NULL, first, NULL);
    second();
}