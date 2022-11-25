#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char input[256];

    printf("Enter your characters: ");
    scanf("%s", input);

    for (int i = 0; i < strlen(input); i++)
    {
        printf("%c", tolower(input[i]));
    }
    printf("\n");
    return 0;
}