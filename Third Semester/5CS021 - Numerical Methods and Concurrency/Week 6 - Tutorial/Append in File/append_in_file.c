#include <stdio.h>
#include <string.h>

void append_in_file(FILE **fptr, char name[], char filename[]);

int main()
{
    char name[100];
    char filename[24];
    FILE *fprt;

    printf("Which file do you want to append? ");
    scanf("%s", filename);

    printf("Enter your name: ");
    scanf("%s", name);

    append_in_file(&fprt, name, filename);
    fclose(fprt);
    return 0;
}

void append_in_file(FILE **fptr, char name[], char filename[])
{
    strcat(filename, ".txt");
    *fptr = fopen(filename, "a");
    if (*fptr == NULL)
    {
        printf("Error creating file!\n");
    }
    else
    {
        printf("Successfully created the file!\n");
        fputs(strcat(name, " "), *fptr);
    }
}