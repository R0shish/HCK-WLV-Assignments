#include <stdio.h>

struct student
{
    char student_name[15];
    int roll_no;
    int marks;
};

void take_input(struct student *student_data)
{
    int i;
    for (i = 0; i < 10; i++)
    {
        printf("Enter information about student %d\n", i + 1);
        printf("Enter name: ");
        scanf("%s", student_data[i].student_name);
        printf("Enter roll no: ");
        scanf("%d", &student_data[i].roll_no);
        printf("Enter marks: ");
        scanf("%d", &student_data[i].marks);
    }
}

void display_info(struct student *student_data)
{
    int i;
    printf("------------------------------------------\n");
    printf("\nAll student details\n\n");
    for (i = 0; i < 10; i++)
    {
        printf("Name: %s\n", student_data[i].student_name);
        printf("Roll no: %d\n", student_data[i].roll_no);
        printf("Marks: %d\n", student_data[i].marks);
        printf("------------------------------------------\n");
    }
}

int main()
{
    struct student student_data[10];
    take_input(student_data);
    display_info(student_data);
    return 0;
}
