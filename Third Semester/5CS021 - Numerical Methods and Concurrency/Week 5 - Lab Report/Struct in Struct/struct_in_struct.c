#include <stdio.h>

#define MAX_SIZE 3

struct Student
{
    struct StudentInfo
    {
        char name[50];
        int age;
        char date_of_birth[12];
    } student_info;

    int roll_no;
    int marks;
};

void take_input(struct Student *student_data)
{
    int i;
    for (i = 0; i < MAX_SIZE; i++)
    {
        printf("Enter information about student %d\n", i + 1);
        printf("Enter name: ");
        scanf("%s", student_data[i].student_info.name);
        printf("Enter age: ");
        scanf("%d", &student_data[i].student_info.age);
        printf("Enter date of birth: ");
        scanf("%s", student_data[i].student_info.date_of_birth);
        printf("Enter roll no: ");
        scanf("%d", &student_data[i].roll_no);
        printf("Enter marks: ");
        scanf("%d", &student_data[i].marks);
    }
}

void display_info(struct Student *student_data)
{
    int i;
    printf("------------------------------------------\n");
    printf("\nAll student details\n\n");
    for (i = 0; i < MAX_SIZE; i++)
    {
        printf("Name: %s\n", student_data[i].student_info.name);
        printf("Age: %d\n", student_data[i].student_info.age);
        printf("Date of birth: %s\n", student_data[i].student_info.date_of_birth);
        printf("Roll no: %d\n", student_data[i].roll_no);
        printf("Marks: %d\n", student_data[i].marks);
        printf("------------------------------------------\n");
    }
}

int main()
{

    struct Student students[MAX_SIZE];
    take_input(students);
    display_info(students);
    return 0;
}