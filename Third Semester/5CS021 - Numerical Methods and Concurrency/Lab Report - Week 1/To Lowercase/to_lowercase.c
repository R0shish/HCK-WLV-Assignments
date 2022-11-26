#include <stdio.h>
#include <string.h>

char *lowercase(char *string)
{
    for (int i = 0; i < strlen(string); i++)
    {
        if (string[i] >= 65 && string[i] <= 90)
        {
            string[i] = string[i] + 32;
        }
    }
    return string;
}

int main()
{
    char input[256];
    printf("Enter your characters: ");
    fgets(input, 255, stdin);
    printf("%s", lowercase(input));
    return 0;
}
