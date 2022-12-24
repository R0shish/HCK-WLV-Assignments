#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 10

struct Employee
{
    char name[50];
    char post[50];
    int salary;
};

void take_input(struct Employee *employee_data)
{
    int i;
    for (i = 0; i < MAX_SIZE; i++)
    {
        printf("Enter information about employee %d\n", i + 1);
        printf("Enter name: ");
        scanf("%s", employee_data[i].name);
        printf("Enter post: ");
        scanf("%s", employee_data[i].post);
        printf("Enter salary: ");
        scanf("%d", &employee_data[i].salary);
    }
}

void display_info(struct Employee *employee_data, int *filtered_count)
{
    int i;
    printf("------------------------------------------\n");
    printf("\nEmployee whose salary is greater than 10,000\n\n");
    for (i = 0; i < *filtered_count; i++)
    {
        printf("Name: %s\n", employee_data[i].name);
        printf("Post: %s\n", employee_data[i].post);
        printf("Salary: %d\n", employee_data[i].salary);
        printf("------------------------------------------\n");
    }
}

struct Employee *filter(struct Employee employees[], int *filtered_count)
{
    struct Employee *filtered_employee = (struct Employee *)malloc(sizeof(struct Employee) * MAX_SIZE);

    int i, count = 0;
    for (i = 0; i < MAX_SIZE; i++)
    {
        if (employees[i].salary > 10000)
        {
            strcpy(filtered_employee[count].name, employees[i].name);
            strcpy(filtered_employee[count].post, employees[i].post);
            filtered_employee[count].salary = employees[i].salary;
            count++;
        }
    }

    *filtered_count = count;
    return filtered_employee;
}

int main()
{
    struct Employee employees[MAX_SIZE];
    take_input(employees);
    int filtered_count;
    struct Employee *filtered_employee = filter(employees, &filtered_count);
    display_info(filtered_employee, &filtered_count);
    free(filtered_employee);
    return 0;
}