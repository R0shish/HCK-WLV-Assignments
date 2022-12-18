#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *int_ptr = (int *)malloc(sizeof(int));
    char *char_ptr = (char *)malloc(sizeof(char));
    float *float_ptr = (float *)malloc(sizeof(float));

    printf("Enter an integer: ");
    scanf("%d", int_ptr);

    printf("Enter a char: ");
    // To skip leading whitespace characters and only read the first non-whitespace character
    // A space before the %c format specifier is used.
    scanf(" %c", char_ptr);

    printf("Enter a float: ");
    scanf("%f", float_ptr);

    printf("%d, %c, %g\n", *int_ptr, *char_ptr, *float_ptr);
    printf("%lu bytes, %lu bytes, %lu bytes\n", sizeof(*int_ptr), sizeof(*char_ptr), sizeof(*float_ptr));

    free(int_ptr);
    free(char_ptr);
    free(float_ptr);

    return 0;
}