#include <stdio.h>
#include <math.h>

int main()
{
	// opening file in read mode using FILE type pointer
	FILE *fptr = fopen("datasetLR1.txt", "r");
	FILE *fptr1 = fopen("datasetLR2.txt", "r");
	FILE *fptr2 = fopen("datasetLR3.txt", "r");
	FILE *fptr3 = fopen("datasetLR4.txt", "r");

	int x, y; // variables to store dependent and independent variable
	// variables initialization for calculations
	int n = 0;
	float sum_X = 0;
	float sum_Y = 0;
	float sum_XY = 0;
	float sum_Xsq = 0;
	float calc_A, calc_B, y_Pred, user_x;

	// check data until end of file is found in the first file
	while (fscanf(fptr, "%d, %d", &x, &y) != EOF)
	{
		sum_X += x;
		sum_Y += y;
		sum_Xsq += pow(x, 2);
		sum_XY += (x * y);
		n++;
	}
	// check data until end of file is found in the second file
	while (fscanf(fptr1, "%d, %d", &x, &y) != EOF)
	{
		sum_X += x;
		sum_Y += y;
		sum_Xsq += pow(x, 2);
		sum_XY += (x * y);
		n++;
	}
	// check data until end of file is found in the third file
	while (fscanf(fptr2, "%d, %d", &x, &y) != EOF)
	{
		sum_X += x;
		sum_Y += y;
		sum_Xsq += pow(x, 2);
		sum_XY += (x * y);
		n++;
	}
	// check data until end of file is found in the fourth file
	while (fscanf(fptr3, "%d, %d", &x, &y) != EOF)
	{
		sum_X += x;
		sum_Y += y;
		sum_Xsq += pow(x, 2);
		sum_XY += (x * y);
		n++;
	}

	// calculate A and B using linear regression formula
	calc_A = ((sum_Y * sum_Xsq) - (sum_X * sum_XY)) / ((n * sum_Xsq) - pow(sum_X, 2));
	calc_B = ((n * sum_XY) - (sum_X * sum_Y)) / ((n * sum_Xsq) - pow(sum_X, 2));

	// prints the value of A and B
	printf("A = %0.2f", calc_A);
	printf("\nB = %0.2f", calc_B);

	// prints the linear equation obtained from the above calculation
	printf("\nThe linear equation obtained from the given calculation is : %0.2fx + %0.2f\n", calc_A, calc_B);

	// asks user for the value of x to predict y variable
	printf("\n x coordinate to predict y is : ");
	scanf("%f", &user_x);

	// calculation to predict y variable
	y_Pred = calc_B * user_x + calc_A;

	// prints the value of x
	printf("The value of x = %0.2f", user_x);

	// prints the predicted value
	printf("\nThe predicted result is y = %0.2f", y_Pred);

	// close the opened files
	fclose(fptr);
	fclose(fptr1);
	fclose(fptr2);
	fclose(fptr3);

	return 0;
}
