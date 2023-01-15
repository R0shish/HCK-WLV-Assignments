#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

int diff, start = 1, finish;
int *arr, e, found = 0;

void *searchElement(void *p);
void take_input(int **arr, int *arr_size);

int main()
{
    int arr_size;
    take_input(&arr, &arr_size);

    printf("Which element do you want to search? ");
    scanf("%d", &e);

    pthread_t *thrID;
    int num;
    printf("How many threads do you want? ");
    scanf("%d", &num);

    if (arr_size % num == 0)
    {
        thrID = (pthread_t *)malloc(num * sizeof(pthread_t));
        diff = arr_size / num;
        finish = diff;
        for (int i = 0; i < num; i++)
            pthread_create(&thrID[i], NULL, searchElement, NULL);
        for (int i = 0; i < num; i++)
            pthread_join(thrID[i], NULL);
        if (!found)
            printf("Element not found.\n");
        free(thrID);
    }
    else
    {
        printf("The thread cannot be created.\n");
    }
    return 0;
}

void take_input(int **arr, int *arr_size)
{
    int i;
    printf("Enter a number: ");
    scanf("%d", arr_size);

    *arr = (int *)malloc(*arr_size * sizeof(int));

    for (i = 0; i < *arr_size; i++)
        (*arr)[i] = i + 1;
}

void *searchElement(void *p)
{
    for (int i = start; i <= finish; i++)
    {
        if (arr[i - 1] == e)
        {
            printf("Element found at index %d.\n", i - 1);
            found = 1;
        }
    }
    start += diff;
    finish += diff;
}