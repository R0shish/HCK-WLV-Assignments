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
    struct student s1;

    printf("Enter student name: ");
    char student_name[15];
    scanf("%s", student_name);
    strcpy(s1.student_name, student_name);

    printf("Enter student roll no: ");
    scanf("%d", &s1.roll_no);

    printf("Enter student marks: ");
    scanf("%f", &s1.marks);

    printf("%s has roll no %d and got %g marks.\n", s1.student_name, s1.roll_no, s1.marks);
    return 0;
}