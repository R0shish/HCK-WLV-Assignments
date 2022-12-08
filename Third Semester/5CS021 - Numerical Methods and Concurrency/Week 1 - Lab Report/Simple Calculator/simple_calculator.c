#include <stdio.h>

int main()
{
    float first_number, second_number, sum;
    char operator;
    int incorrect_input = 1;

    printf("Enter the first number: ");
    scanf("%f", &first_number);

    printf("Enter the second number: ");
    scanf("%f", &second_number);

    while (incorrect_input)
    {
        incorrect_input = 0;

        printf("Enter the operator (+, -, *, /, %%): ");
        scanf("%s", &operator);

        switch (operator)
        {
        case '+':
            printf("The sum of the two numbers is %g\n", first_number + second_number);
            break;

        case '-':
            printf("The difference of the two numbers is %g\n", first_number - second_number);
            break;
        case '*':
            printf("The product of the two numbers is %g\n", first_number * second_number);
            break;
        case '/':
            printf("The quotient of the two numbers is %g\n", first_number / second_number);
            break;
        case '%':
            printf("The modulus of the two numbers is %d\n", (int)first_number % (int)second_number);
            break;

        default:
            incorrect_input = 1;
            printf("Wrong input. Please enter a valid operator and try again!\n");
            break;
        }
    }

    return 0;
}