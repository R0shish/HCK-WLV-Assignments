#include <stdio.h>
#include <stdlib.h>
#include "lodepng.h"

int main()
{
    unsigned int error;
    unsigned char *image;
    unsigned int width, height;

    error = lodepng_decode32_file(&image, &width, &height, "image.png");
    if (error)
        printf("error %d: %s\n", error, lodepng_error_text(error));

    for (int i = 0; i < width * height * 4; i += 4)
        image[i] = image[i + 1] = image[i + 2] = (image[i] + image[i + 1] + image[i + 2]) / 3;

    error = lodepng_encode32_file("output.png", image, width, height);

    if (error)
        printf("error %d: %s\n", error, lodepng_error_text(error));

    free(image);
    return 0;
}