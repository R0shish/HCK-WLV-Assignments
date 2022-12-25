#include <stdio.h>
#include <string.h>

int main()
{
    char name[20];
    FILE *fptr;
    fptr = fopen("names.txt", "a");
    if (fptr == NULL)
    {
        printf("Error creating file!\n");
    }
    else
    {
        for (int i = 0; i < 3; i++)
        {
            printf("Enter your name: ");
            scanf("%s", name);
            fputs(strcat(name, "\n"), fptr);
        }
    }
    fclose(fptr);
    return 0;
}
