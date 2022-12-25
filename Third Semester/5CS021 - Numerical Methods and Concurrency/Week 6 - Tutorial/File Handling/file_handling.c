#include <stdio.h>

void read_file(FILE **fprt);
void delete_file();
void create_file(FILE **fptr);

int main()
{
    FILE *fptr;

    read_file(&fptr);
    delete_file();
    create_file(&fptr);

    fclose(fptr);
    return 0;
}

void read_file(FILE **fptr)
{
    *fptr = fopen("text.txt", "r");
    if (*fptr == NULL)
    {
        printf("Error reading file!\n");
    }
    else
    {
        printf("Successfully read the file!\n");
    }
}

void delete_file()
{
    int result = remove("text.txt");
    if (result == 0)
    {
        printf("File deleted successfully\n");
    }
    else
    {
        printf("Error deleting file\n");
    }
}

void create_file(FILE **fptr)
{
    *fptr = fopen("text.txt", "w");
    if (*fptr == NULL)
    {
        printf("Error creating file!\n");
    }
    else
    {
        printf("Successfully created the file!\n");
    }
}