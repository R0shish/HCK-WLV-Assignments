#include <stdio.h>

int main()
{
    FILE *fptr;
    int x, y;
    char filename[] = "test.txt";

    fptr = fopen(filename, "w");
    if (fptr == NULL)
    {
        printf("Error opening file!\n");
    }

    printf("Enter the values of x: ");
    scanf("%d", &x);
    printf("Enter the values of y: ");
    scanf("%d", &y);
    fprintf(fptr, "The value of x is %d. The value of y is %d.", x, y);
    fclose(fptr);

    fptr = fopen(filename, "r");
    if (fptr == NULL)
    {
        printf("Error reading file!\n");
    }
    while (!feof(fptr))
    {
        fscanf(fptr, "The value of x is %d. The value of y is %d.", &x, &y);
    }

    printf("The final values are: %d and %d.\n", x, y);
    fclose(fptr);
    return 0;
}