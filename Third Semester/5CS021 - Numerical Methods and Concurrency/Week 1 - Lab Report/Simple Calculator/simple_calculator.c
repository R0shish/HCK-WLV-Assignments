#include <stdio.h>

int main()
{
    float first_number, second_number, sum;
    char operator;

    printf("Enter the first number: ");
    scanf("%f", &first_number);

    printf("Enter the second number: ");
    scanf("%f", &second_number);

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
        printf("Wrong input");
        break;
    }

    return 0;
}