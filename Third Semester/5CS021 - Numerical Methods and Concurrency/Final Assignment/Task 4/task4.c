#include <stdio.h>
#include "lodepng.h"
#include <stdlib.h>
#include <pthread.h>

int ***arr;
unsigned char *image;

struct pixels
{
    int start_h, end_h, h, w, thread_id, kernel_size;
};

void *blur(void *ptr)
{

    int i, j, k, l, m;
    struct pixels *arg = (struct pixels *)ptr;
    int start_h = arg->start_h, end_h = arg->end_h, kernel_size = arg->kernel_size;
    int thread_id = arg->thread_id, height = arg->h, width = arg->w;

    for (i = start_h; i <= end_h; i++)
    {
        for (j = 0; j < width; j++)
        {
            int avg_red = 0, avg_green = 0, avg_blue = 0, num_of_pixels = 0;

            for (l = -kernel_size; l <= kernel_size; l += kernel_size)
            {
                for (m = -kernel_size; m <= kernel_size; m += kernel_size)
                {
                    int x_pixel = i + l;
                    int y_pixel = j + m;

                    if (x_pixel >= 0 && y_pixel >= 0 && x_pixel < height && y_pixel < width)
                    {
                        avg_red += arr[x_pixel][y_pixel][0];
                        avg_green += arr[x_pixel][y_pixel][1];
                        avg_blue += arr[x_pixel][y_pixel][2];
                        num_of_pixels++;
                    }
                }
            }
            image[4 * width * i + 4 * j + 0] = avg_red / num_of_pixels;
            image[4 * width * i + 4 * j + 1] = avg_green / num_of_pixels;
            image[4 * width * i + 4 * j + 2] = avg_blue / num_of_pixels;
        }
    }
    pthread_exit(0);
}

void main()
{

    unsigned int error, width, height;
    int i, j, k;
    int num_of_threads, kernel_size;
    char filename[20];

    printf("Enter image you want to blur (with .png extension): ");
    scanf("%s", &filename);

    error = lodepng_decode32_file(&image, &width, &height, filename);

    printf("\nEnter number of threads to utilize to blur the image: ");
    scanf("%d", &num_of_threads);

    if (num_of_threads > height)
    {
        num_of_threads = num_of_threads % height + 1;
        printf("\nThe number of threads is greater than height\nAutomatically choose required number of threads: %d threads", num_of_threads);
    }

    printf("\n\nPlease enter the size(level of blur) of the Kernel(blur matrix) that you want to use\nEnter \"1\" for 3x3, \"2\" for 5x5, \"3\" for 7x7 matrix and so on: ");
    scanf("%d", &kernel_size);

    arr = (int ***)malloc(height * sizeof(int **));
    for (i = 0; i < height; i++)
    {
        arr[i] = (int **)malloc(width * sizeof(int *));
        for (j = 0; j < width; j++)
        {
            arr[i][j] = (int *)malloc(3 * sizeof(int));
        }
    }

    if (error)
    {
        printf("Error in decoding image %d: %s\n", error, lodepng_error_text(error));
    }
    else
    {
        for (i = 0; i < height; i++)
        {
            for (j = 0; j < width; j++)
            {
                for (k = 0; k < 3; k++)
                {
                    arr[i][j][k] = image[4 * width * i + 4 * j + k];
                }
            }
        }
    }

    int slice_height[num_of_threads];
    for (i = 0; i < num_of_threads; i++)
    {
        slice_height[i] = height / num_of_threads;
    }
    int reminderHeight = height % num_of_threads;
    for (i = 0; i < reminderHeight; i++)
    {
        slice_height[i]++;
    }
    int start_height[num_of_threads], end_height[num_of_threads];
    for (i = 0; i < num_of_threads; i++)
    {
        if (i == 0)
        {
            start_height[i] = 0;
        }
        else
        {
            start_height[i] = end_height[i - 1] + 1;
        }
        end_height[i] = start_height[i] + slice_height[i] - 1;
    }

    struct pixels divider[num_of_threads];
    pthread_t threads[num_of_threads];
    int thid = 1;
    for (i = 0; i < num_of_threads; i++)
    {
        divider[i].start_h = start_height[i];
        divider[i].end_h = end_height[i];
        divider[i].h = height;
        divider[i].w = width;
        divider[i].thread_id = thid;
        divider[i].kernel_size = kernel_size;
        thid++;
        pthread_create(&threads[i], NULL, blur, &divider[i]);
    }

    for (i = 0; i < num_of_threads; i++)
    {
        pthread_join(threads[i], NULL);
    }

    unsigned char *png;
    char image_name[20];
    size_t pngsize;

    printf("\n\nImage has been blurred. Enter the name of output blurred image (with .png extension): ");
    scanf("%s", &image_name);
    lodepng_encode32(&png, &pngsize, image, width, height);
    lodepng_save_file(png, pngsize, image_name);
}
