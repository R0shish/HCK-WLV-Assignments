/*
  MPI_Init must be used to initialise MPI.
  MPI_Comm_size finds out how many processes is running, i.e. the number following the -n switch.
  MPI_COMM_WORLD is the default communicator group.
  MPI_Comm_rank gets the process rank. The process with rank 0 is thought of as the starting process
  MPI_Finalize closes down MPI. All processes must call this to close down MPI.
*/

#include <stdio.h>
#include <mpi.h>

int main(int argc, char **argv)
{
  int size, rank;

  MPI_Init(NULL, NULL);
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  printf("I am %d of %d\n", rank, size);
  MPI_Finalize();

  return 0;
}

