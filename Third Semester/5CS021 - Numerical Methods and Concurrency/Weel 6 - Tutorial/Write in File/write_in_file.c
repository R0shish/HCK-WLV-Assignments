#include <stdio.h>
#include <string.h>

void write_in_file(FILE **fptr, char name[], char filename[]);

int main()
{
    char name[20];
    char filename[24];
    FILE *fprt;

    printf("What do you want to name the file? ");
    scanf("%s", filename);

    printf("Enter your name: ");
    scanf("%s", name);

    write_in_file(&fprt, name, filename);
    fclose(fprt);
    return 0;
}

void write_in_file(FILE **fptr, char name[], char filename[])
{
    sprintf(filename, "%s.txt", filename);
    *fptr = fopen(filename, "w");
    if (*fptr == NULL)
    {
        printf("Error creating file!\n");
    }
    else
    {
        printf("Successfully created the file!\n");
        fputs(name, *fptr);
    }
}