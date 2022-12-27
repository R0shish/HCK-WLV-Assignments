#include <stdio.h>
#include <string.h>

char *sort_string(char string[])
{
    char temp;
    int len = strlen(string);
    for (int i = 0; i < len; i++)
    {
        for (int j = 0; j < (len - 1); j++)
        {
            if (string[j] > string[j + 1])
            {
                temp = string[j];
                string[j] = string[j + 1];
                string[j + 1] = temp;
            }
        }
    }
    return string;
}

// int compare_string(char first_string[], char second_string[])
// {
//     for (int i = 0; i < strlen(first_string); i++)
//     {
//         if (first_string[i] != second_string[i])
//             return 0;
//     }
//     return 1;
// }

int main()
{
    char first_string[20];
    char second_string[20];

    printf("Enter first word: ");
    scanf("%s", first_string);
    printf("Enter second word: ");
    scanf("%s", second_string);

    char *sorted_first = sort_string(first_string);
    char *sorted_second = sort_string(second_string);

    if (strcmp(sorted_first, sorted_second) == 0)
    {
        printf("The words are anagrams.\n");
    }
    else
    {
        printf("The words are not anagrams.\n");
    }
    return 0;
}