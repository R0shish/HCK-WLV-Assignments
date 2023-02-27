/*
  This program demonstrates how to send a message from the process with rank
  0 to other processes. The other processes execute a blocking receive
  instruction. This causes them to wait for a message before proceeding to
  print out the data that was received. Process 0 wants to receieve from
  process 1 before process 2. When process 1 goes to sleep blocking causes
  the send from process 2 to process 0 to be delayed by 5 seconds.
*/

#include <stdio.h>
#include <mpi.h>
#include <unistd.h>

int main(int argc, char **argv)
{
  int size, rank;

  MPI_Init(NULL, NULL);
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  if (size != 3)
  {
    if (rank == 0)
    {
      printf("This program needs to run on exactly 3 processes\n");
    }
  }
  else
  {
    if (rank == 0)
    {
      int x, y;
      MPI_Recv(&x, 1, MPI_INT, 1, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
      printf("Received %d from process %d\n", x, 1);
      MPI_Recv(&y, 1, MPI_INT, 2, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
      printf("Received %d from process %d\n", y, 2);
    }
    else
    {
      if (rank == 1)
      {
        usleep(5000000);
      }
      int number = rank + 10;
      MPI_Send(&number, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);
    }
  }
  MPI_Finalize();

  return 0;
}
