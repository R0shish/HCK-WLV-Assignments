#include <stdio.h>

struct Limit
{
    int lower_limit;
    int upper_limit;
};

void displayNumbers(struct Limit *limits);

int main()
{
    struct Limit limits;
    printf("Enter lower limit: ");
    scanf("%d", &limits.lower_limit);
    printf("Enter upper limit: ");
    scanf("%d", &limits.upper_limit);
    displayNumbers(&limits);
    return 0;
}

void displayNumbers(struct Limit *limits)
{
    int i;
    for (i = limits->lower_limit + 1; i < limits->upper_limit; i++)
    {
        printf("%d ", i);
    }
    printf("\n");
}