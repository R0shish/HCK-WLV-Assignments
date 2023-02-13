#include <stdio.h>
#include <math.h>

void read_data(FILE *fptr, float *sum_X, float *sum_Y, float *sum_XY, float *sum_Xsq, int *n);

int main()
{
    FILE *fptr[4];
    fptr[0] = fopen("datasetLR1.txt", "r");
    fptr[1] = fopen("datasetLR2.txt", "r");
    fptr[2] = fopen("datasetLR3.txt", "r");
    fptr[3] = fopen("datasetLR4.txt", "r");

    int n = 0;
    float sum_X = 0;
    float sum_Y = 0;
    float sum_XY = 0;
    float sum_Xsq = 0;
    float calc_A, calc_B, y_Pred, user_x;

    for (int i = 0; i < 4; i++)
        read_data(fptr[i], &sum_X, &sum_Y, &sum_XY, &sum_Xsq, &n);

    calc_A = ((sum_Y * sum_Xsq) - (sum_X * sum_XY)) / ((n * sum_Xsq) - pow(sum_X, 2));
    calc_B = ((n * sum_XY) - (sum_X * sum_Y)) / ((n * sum_Xsq) - pow(sum_X, 2));

    printf("A = %0.2f\n", calc_A);
    printf("B = %0.2f\n", calc_B);

    printf("The linear equation obtained from the given calculation is : %0.2fx + %0.2f\n", calc_A, calc_B);

    printf("\nEnter x coordinate to predict y: ");
    scanf("%f", &user_x);

    y_Pred = calc_B * user_x + calc_A;

    printf("The value of x = %0.2f", user_x);

    printf("\nThe predicted result is y = %0.2f\n", y_Pred);

    for (int i = 0; i < 4; i++)
        fclose(fptr[i]);

    return 0;
}

void read_data(FILE *fptr, float *sum_X, float *sum_Y, float *sum_XY, float *sum_Xsq, int *n)
{
    int x, y;
    while (fscanf(fptr, "%d, %d", &x, &y) != EOF)
    {
        (*sum_X) += x;
        (*sum_Y) += y;
        (*sum_Xsq) += pow(x, 2);
        (*sum_XY) += (x * y);
        (*n)++;
    }
}