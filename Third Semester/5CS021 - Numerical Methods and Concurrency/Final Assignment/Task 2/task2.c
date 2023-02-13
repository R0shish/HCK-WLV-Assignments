#include <stdio.h>
#include <pthread.h>
#include <math.h>

#define NUM_THREADS 4

double sum[NUM_THREADS];
int iterations_per_thread;

void *leibniz_series(void *threadid);

int main()
{
    int num_iterations;
    int num_threads;
    pthread_t threads[NUM_THREADS];
    int error;
    int i;
    double pi;

    printf("Enter the number of iterations: ");
    scanf("%d", &num_iterations);
    printf("Enter the number of threads: ");
    scanf("%d", &num_threads);

    iterations_per_thread = num_iterations / num_threads;

    for (i = 0; i < num_threads; i++)
    {
        error = pthread_create(&threads[i], NULL, leibniz_series, (void *)(intptr_t)i);
        if (error)
        {
            printf("Error creating thread\n");
            return 1;
        }
    }

    for (i = 0; i < num_threads; i++)
        pthread_join(threads[i], NULL);

    pi = 0;

    for (i = 0; i < num_threads; i++)
        pi += sum[i];
    pi *= 4;

    printf("The calculated value of Pi is: %f\n", pi);
    pthread_exit(NULL);

    return 0;
}

void *leibniz_series(void *threadid)
{
    int start = (intptr_t)threadid * iterations_per_thread;
    int end = (intptr_t)threadid * iterations_per_thread + iterations_per_thread;

    int i;
    double result = 0;

    for (i = start; i < end; i++)
        result += pow(-1, i) / (2 * i + 1);

    sum[(intptr_t)threadid] = result;
    pthread_exit(NULL);
}