#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    int size, rank, count;
    MPI_Status status;

    MPI_Init(NULL, NULL);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (rank == 0)
    {
        for (int i = 1; i < size; i++)
        {
            MPI_Recv(&count, 1, MPI_INT, i, 0, MPI_COMM_WORLD, &status);
            printf("Node ID: %d, Count: %d, Tag: %d\n", status.MPI_SOURCE, count, status.MPI_TAG);
        }
    }
    else
    {
        int random = rand() % 100;
        MPI_Send(&random, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
