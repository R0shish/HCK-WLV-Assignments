#include <stdio.h>
#include <stdlib.h>
#include "lodepng.h"

int main()
{
    unsigned int error;
    unsigned char *image;
    unsigned int width, height;

    error = lodepng_decode32_file(&image, &width, &height, "TestImage.png");

    if (error)
    {
        printf("error %d: %s\n", error, lodepng_error_text(error));
    }

    int i;
    for (i = 0; i < width * height * 4; i = i + 4)
    {
        printf("R=%d, G=%d, B=%d, T=%d \n", image[i], image[i + 1], image[i + 2], image[i + 3]);
    }

    image[4] = 3;
    image[5] = 255;
    image[6] = 2;

    image[12] = 2;
    image[13] = 3;
    image[14] = 255;

    image[24] = 40;
    image[25] = 25;
    image[26] = 75;

    image[28] = 100;
    image[29] = 40;
    image[30] = 40;

    error = lodepng_encode32_file("output.png", image, width, height);

    if (error)
    {
        printf("error %d: %s\n", error, lodepng_error_text(error));
    }

    free(image);
    return 0;
}