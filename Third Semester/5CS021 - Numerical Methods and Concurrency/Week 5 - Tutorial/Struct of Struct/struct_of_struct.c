#include <stdio.h>
#include <string.h>

struct student
{
    char student_name[15];
    int roll_no;
    struct marks
    {
        char module_name[15];
        int obtained_mark;
    } mark[3];
};

int main()
{
    int i, arr_size;

    printf("How many student data would you like to enter? ");
    scanf("%d", &arr_size);

    struct student s1[arr_size];
    struct marks mark1[3];

    for (i = 0; i < arr_size; i++)
    {
        printf("Enter student name : ");
        char student_name[15];
        scanf("%s", student_name);
        strcpy(s1[i].student_name, student_name);

        printf("Enter student roll no for %s: ", student_name);
        scanf("%d", &s1[i].roll_no);

        for (int j = 0; j < 3; j++)
        {
            printf("Enter module name: ");
            char module_name[15];
            scanf("%s", module_name);
            strcpy(s1[i].mark[j].module_name, module_name);

            printf("Enter obtained marks for %s: ", module_name);
            scanf("%d", &s1[i].mark[j].obtained_mark);
        }

        printf("\n");
    }

    printf("All Students:\n");
    for (i = 0; i < arr_size; i++)
    {
        printf("%d. %s\n", i + 1, s1[i].student_name);
    }

    printf("Enter the number whose results you want to print: ");
    int choice;
    scanf("%d", &choice);
    choice--;

    printf("Student Name: %s\nRoll No: %d\n", s1[choice].student_name, s1[choice].roll_no);
    for (i = 0; i < 3; i++)
    {
        printf("%d in %s\n", s1[choice].mark[i].obtained_mark, s1[choice].mark[i].module_name);
    }

    return 0;
}