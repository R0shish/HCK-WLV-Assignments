#include <stdio.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    int i, c, nstart = 1, nfinish = 10000;
    int rank, size;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int local_n = (nfinish - nstart + 1) / size;
    int start = nstart + rank * local_n;
    int end = start + local_n - 1;

    if (rank == size - 1)
        end = nfinish;

    printf("Process %d: Prime numbers between %d and %d are:\n", rank, start, end);

    for (i = start; i <= end; i++)
    {
        for (c = 2; c <= i - 1; c++)
        {
            if (i % c == 0)
                break;
        }
        if (c == i)
            printf("Process %d: %d\n", rank, i);
    }

    MPI_Finalize();
    return 0;
}
