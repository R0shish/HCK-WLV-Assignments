/*
  - Process 0 sends x to process 1 and y to processes 2. "1, MPI_INT"
    indicates that the message consists of one integer.
  - Processes other than rank 0 wait to receive a message using MPI_Recv.
    The "0, 0" indicates that the message is expected from process 0 and
    should have the tag 0. The result is stored in the number variable.
*/

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main(int argc, char **argv)
{
  int size, rank;

  MPI_Init(NULL, NULL);
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  // if (size != 3)
  // {
  //   if (rank == 0)
  //   {
  //     printf("This program needs to run on exactly 3 processes\n");
  //   }
  // }
  // else
  // {
  if (rank == 0)
  {
    // int x = 9;
    // int y = 17;

    int x[size];
    for (int i = 0; i < size; i++)
    {
      x[i] = rand() % 100;
    }
    for (int i = 1; i < size; i++)
    {
      MPI_Send(&x[i], 1, MPI_INT, i, 0, MPI_COMM_WORLD);
    }
    // MPI_Send(&y, 1, MPI_INT, 2, 0, MPI_COMM_WORLD);
  }
  else
  {
    int number;
    MPI_Recv(&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
    printf("Process %d received %d\n", rank, number);
  }
  // }
  MPI_Finalize();

  return 0;
}
