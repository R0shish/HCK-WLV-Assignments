#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

int diff, start = 1, finish;

void *displayNumber(void *p)
{
    for (int i = start; i <= finish; i++)
    {
        if (i % 2 == 1)
            printf("%d\n", i);
    }
    start += diff;
    finish += diff;
}

int main()
{
    pthread_t *thrID;
    int num, y = 1000;
    printf("How many threads do you want? ");
    scanf("%d", &num);

    if (y % num == 0)
    {
        thrID = (pthread_t *)malloc(num * sizeof(pthread_t));
        diff = y / num;
        finish = diff;
        for (int i = 0; i < num; i++)
        {
            pthread_create(&thrID[i], NULL, displayNumber, NULL);
        }
        for (int i = 0; i < num; i++)
        {
            pthread_join(thrID[i], NULL);
        }
        free(thrID);
    }
    else
    {
        printf("The thread cannot be created.\n");
    }
    return 0;
}