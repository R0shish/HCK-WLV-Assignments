#include <stdio.h>

int main()
{
    int final_score;

    printf("Enter your final score: ");
    scanf("%d", &final_score);

    if (final_score >= 80 && final_score < 100)
    {
        printf("Congratulation! You passed with Distinction!\n");
    }
    else if (final_score >= 60 && final_score < 80)
    {
        printf("Impressive! You passed with First Division!\n");
    }
    else if (final_score >= 50 && final_score < 60)
    {
        printf("Quite Good! You passed with Second Division!\n");
    }
    else if (final_score >= 40 && final_score < 50)
    {
        printf("Not Bad! You passed with Third Division!\n");
    }
    else if (final_score >= 0 && final_score < 40)
    {
        printf("Unfortunately! You failed :(( !\n");
    }
    else
    {
        printf("Please enter a valid input!\n");
    }
    return 0;
}