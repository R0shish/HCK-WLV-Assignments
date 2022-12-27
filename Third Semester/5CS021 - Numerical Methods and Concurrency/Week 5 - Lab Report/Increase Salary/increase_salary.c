#include <stdio.h>

#define MAX_SIZE 5

struct Employee
{
    char name[20];
    int salary;
    int hours_of_work;
};

void take_input(struct Employee *employee_data)
{
    int i;
    for (i = 0; i < MAX_SIZE; i++)
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

void display_info(struct Employee *employee_data)
{
    int i;
    printf("------------------------------------------\n");
    printf("\nAll Employees Details\n\n");
    for (i = 0; i < MAX_SIZE; i++)
    {
        printf("Name: %s\n", employee_data[i].name);
        printf("Salary: %d\n", employee_data[i].salary);
        printf("Hours of Work: %d\n", employee_data[i].hours_of_work);
        printf("------------------------------------------\n");
    }
}

int main()
{
    struct Employee employees[5];
    take_input(employees);
    int i;
    for (i = 0; i < MAX_SIZE; i++)
    {
        if (employees[i].hours_of_work >= 8 && employees[i].hours_of_work < 10)
            employees[i].salary += 50;
        else if (employees[i].hours_of_work >= 10 && employees[i].hours_of_work < 12)
            employees[i].salary += 100;
        else if (employees[i].hours_of_work >= 12)
            employees[i].salary += 150;
    }
    display_info(employees);
    return 0;
}