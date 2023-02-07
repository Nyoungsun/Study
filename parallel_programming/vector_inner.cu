#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void printVector(int* c, int* a, int* b, int arraySize) {
    int i;
    printf("{");
    for (i = 0; i < arraySize; i++) {
        printf("%d", a[i]);
        if (i != arraySize - 1) {
            printf(", ");
        }
        else {
            printf("}");
        }
    }

    printf(" · ");
    printf("{");
    for (i = 0; i < arraySize; i++) {
        printf("%d", b[i]);
        if (i != arraySize - 1) {
            printf(", ");
        }
        else {
            printf("}");
        }
    }

    int result = 0;
    for (i = 0; i < arraySize; i++) {
        result += c[i];
    }
    printf(" = {%d}\n", result);
}


void RandArray(int* a, int* b, int arraySize) {
    srand(time(NULL));
    for (int i = 0; i < arraySize; i++) {
        a[i] = rand() % 100 + 1;
        b[i] = rand() % 100 + 1;
    }
}
__global__ void multiKernel(int* c, int* a, int* b)
{
    int i = threadIdx.x;
    c[i] = a[i] * b[i];
}
// Helper function for using CUDA to add vectors in parallel.
cudaError_t multiWithCuda(int* c, int* a, int* b, unsigned int size)
{
    int* dev_a = 0;
    int* dev_b = 0;
    int* dev_c = 0;
    cudaError_t cudaStatus;

    // Allocate GPU buffers for three vectors (two input, one output)    .
    cudaMalloc((void**)&dev_c, size * sizeof(int));
    cudaMalloc((void**)&dev_a, size * sizeof(int));
    cudaMalloc((void**)&dev_b, size * sizeof(int));

    // Copy input vectors from host memory to GPU buffers.
    cudaMemcpy(dev_a, a, size * sizeof(int), cudaMemcpyHostToDevice);
    cudaMemcpy(dev_b, b, size * sizeof(int), cudaMemcpyHostToDevice);

    // Launch a kernel on the GPU with one thread for each element.
    multiKernel << <1, size >> > (dev_c, dev_a, dev_b);

    // Copy output vector from GPU buffer to host memory.
    cudaStatus = cudaMemcpy(c, dev_c, size * sizeof(int), cudaMemcpyDeviceToHost);

Error:
    cudaFree(dev_c);
    cudaFree(dev_a);
    cudaFree(dev_b);

    return cudaStatus;
}

void main()
{
    //init vectorsize & input Vector
    const int arraySize = 5;
    int a[arraySize] = { 0, };
    int b[arraySize] = { 0, };
    int c[arraySize] = { 0, };

    RandArray(a, b, arraySize);

    cudaEvent_t start, stop;
    float time;
    float sp, tp, t1;

    printf("+++Vector Inner Product by Parallel Proccessor+++\n\n");
    //Time record Start
    cudaEventCreate(&start);
    cudaEventCreate(&stop);

    cudaEventRecord(start, 0);
    // Add vectors in parallel.
    cudaError_t cudaStatus = multiWithCuda(c, a, b, arraySize);
    if (cudaStatus != cudaSuccess) {
        fprintf(stderr, "multiWithCuda failed!");
    }

    cudaEventRecord(stop, 0);
    cudaEventSynchronize(stop);
    cudaEventElapsedTime(&time, start, stop);

    //print Vector
    printVector(c, a, b, arraySize);
    printf("time(tp) : %f\n", time);
    tp = (int)time * 10000;

    cudaEventDestroy(start);
    cudaEventDestroy(stop);

    // cudaDeviceReset must be called before exiting in order for profiling and
    // tracing tools such as Nsight and Visual Profiler to show complete traces.
    cudaStatus = cudaDeviceReset();
    if (cudaStatus != cudaSuccess) {
        fprintf(stderr, "cudaDeviceReset failed!");
    }

    printf("\n+++Vector Inner Product by Single Proccessor+++\n\n");
    //Time record Start
    cudaEventCreate(&start);
    cudaEventCreate(&stop);

    cudaEventRecord(start, 0);
    //Employ single Proccessor
    for (int i = 0; i < arraySize; i++) {
        c[i] = a[i] * b[i];
    }
    cudaEventRecord(stop, 0);
    cudaEventSynchronize(stop);
    cudaEventElapsedTime(&time, start, stop);

    //print Vector
    printVector(c, a, b, arraySize);
    printf("time(t1) : %f\n", time);
    t1 = (int)time * 10000;

    cudaEventDestroy(start);
    cudaEventDestroy(stop);

    sp = t1 / tp;
    printf("\n\nArraySize:%d\nSp=%d (::t1/tp)\n", arraySize, sp);
}