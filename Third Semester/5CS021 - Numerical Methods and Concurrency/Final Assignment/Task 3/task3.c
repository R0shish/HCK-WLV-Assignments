#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

clock_t start, end;
double cpu_time;
int *prime_arr, primecount = 0;
FILE *fileptr;

pthread_mutex_t mutex;

struct calculate
{
    int start;
    int finish;
};

int check_prime(int n, int i)
{
    if (n <= 2)
        return (n == 2) ? 1 : 0;
    if (n % i == 0)
        return 0;
    if (i * i > n)
        return 1;
    return check_prime(n, i + 1);
}

void *is_prime(void *ptr)
{
    struct calculate *arg = ptr;
    int st = arg->start, fi = arg->finish;
    int i, j;
    for (i = st; i <= fi; i++)
    {
        int num = *(prime_arr + i);
        if (check_prime(num, 2) == 1)
        {
            pthread_mutex_lock(&mutex);
            primecount++;
            fprintf(fileptr, "%d\n", num);
            pthread_mutex_unlock(&mutex);
        }
    }
}

void main()
{

    int i, n = 0, j = 0, nof = 3;
    FILE *fptr;
    char filename[15], chr;
    int no_of_threads;

    for (i = 1; i <= nof; i++)
    {
        sprintf(filename, "PrimeData%d.txt", i);
        fptr = fopen(filename, "r");
        chr = getc(fptr);
        while (chr != EOF)
        {
            if (chr == '\n')
            {
                if (chr != ' ')
                    n++;
            }
            chr = getc(fptr);
        }
        fclose(fptr);
    }

    printf("Find prime numbers from total (%d) numbers to check. Use multithredding to make process faster", n);
    printf("\n\nEnter the number of threads to utilize: ");
    scanf("%d", &no_of_threads);
    struct calculate divider[no_of_threads];

    prime_arr = (int *)malloc(n * sizeof(int));
    for (i = 1; i <= nof; i++)
    {
        sprintf(filename, "PrimeData%d.txt", i);
        fptr = fopen(filename, "r");

        while (!feof(fptr))
        {
            fscanf(fptr, "%d\n", (prime_arr + j));
            j++;
        }
        fclose(fptr);
    }

    int slice_list[no_of_threads];

    for (i = 0; i < no_of_threads; i++)
        slice_list[i] = n / no_of_threads;

    int reminder = n % no_of_threads;
    for (i = 0; i < reminder; i++)
        slice_list[i]++;

    int start_list[no_of_threads], end_list[no_of_threads];
    for (i = 0; i < no_of_threads; i++)
    {
        if (i == 0)
            start_list[i] = 0;
        else
            start_list[i] = end_list[i - 1] + 1;
        end_list[i] = start_list[i] + slice_list[i] - 1;
    }

    fileptr = fopen("Prime.txt", "w");

    start = clock();
    pthread_mutex_init(&mutex, NULL);

    pthread_t threads[no_of_threads];
    for (i = 0; i < no_of_threads; i++)
    {
        divider[i].start = start_list[i];
        divider[i].finish = end_list[i];
        pthread_create(&threads[i], NULL, is_prime, &divider[i]);
    }

    for (i = 0; i < no_of_threads; i++)
        pthread_join(threads[i], NULL);

    pthread_mutex_destroy(&mutex);
    end = clock();

    cpu_time = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf(" Total Time taken = %lf seconds  ", cpu_time);

    printf("\n\n Total Prime Count: %d\n", primecount);
    fprintf(fptr, "\n\nThere are total of %d prime numbers.", primecount);
    free(prime_arr);
    printf("\nProcess complete!!\n\n\"Prime.txt\" file has been created.\n");
    fclose(fileptr);
}
