#include <stdio.h>
#include <stdlib.h>

struct Employee
{
    char name[50];
    int salary;
    int hours_of_work;
};

void take_input(struct Employee *employee_data, int *size)
{
    int i;
    for (i = 0; i < *size; i++)
    {
        printf("Enter information about employee %d\n", i + 1);
        printf("Enter name: ");
        scanf("%s", employee_data[i].name);
        printf("Enter salary: ");
        scanf("%d", &employee_data[i].salary);
        printf("Enter hours of work: ");
        scanf("%d", &employee_data[i].hours_of_work);
    }
}

void highest_salary(struct Employee *employee_data, int *size)
{
    int i, highest_salary_index = 0;
    int highest_salary = employee_data[0].salary;
    for (i = 1; i < *size; i++)
    {
        if (employee_data[i].salary > highest_salary)
        {
            highest_salary = employee_data[i].salary;
            highest_salary_index = i;
        }
    }

    printf("The highest salary among the employees is of %s i.e. %d\n", employee_data[highest_salary_index].name, highest_salary);
}

int main()
{
    int size;
    printf("How many employees do you want to enter? ");
    scanf("%d", &size);

    struct Employee *employees = (struct Employee *)malloc(size * sizeof(struct Employee));
    take_input(employees, &size);

    highest_salary(employees, &size);
    free(employees);
    return 0;
}