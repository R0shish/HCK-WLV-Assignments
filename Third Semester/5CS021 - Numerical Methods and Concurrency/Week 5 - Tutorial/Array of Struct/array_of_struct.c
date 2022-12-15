#include <stdio.h>
#include <string.h>

struct student
{
    char student_name[15];
    int roll_no;
    float marks;
};

int main()
{
    int i, arr_size;

    printf("How many student data would you like to enter? ");
    scanf("%d", &arr_size);

    struct student s1[arr_size];

    for (i = 0; i < arr_size; i++)
    {
        printf("Enter student name: ");
        char student_name[15];
        scanf("%s", student_name);
        strcpy(s1[i].student_name, student_name);

        printf("Enter student roll no for %s: ", student_name);
        scanf("%d", &s1[i].roll_no);

        printf("Enter student marks for %s: ", student_name);
        scanf("%f", &s1[i].marks);

        printf("\n");
    }

    for (i = 0; i < arr_size; i++)
        printf("%s has roll no %d and got %g marks.\n", s1[i].student_name, s1[i].roll_no, s1[i].marks);
    return 0;
}