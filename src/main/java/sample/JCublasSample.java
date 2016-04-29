package sample;

/*
 * JCublas - Java bindings for CUBLAS, the NVIDIA CUDA BLAS library,
 * to be used with JCuda <br />
 * http://www.jcuda.org
 *
 * Copyright 2009 Marco Hutter - http://www.jcuda.org
 */

import java.util.Random;

import jcuda.*;
import jcuda.jcublas.JCublas;

/**
 * This is a sample class demonstrating the application of JCublas for
 * performing a BLAS 'sgemm' operation, i.e. for computing the matrix <br />
 * C = alpha * A * B + beta * C <br />
 * for single-precision floating point values alpha and beta, and matrices A, B
 * and C of size 1000x1000.
 */
public class JCublasSample
{
    public static void main(String args[])
    {
        testSgemm(2000);
    }

    /**
     * Test the JCublas sgemm operation for matrices of size n x x
     *
     * @param n The matrix size
     */
    public static void testSgemm(int n)
    {
        float alpha = 0.3f;
        float beta = 0;
        int nn = n * n;

        //System.out.println("Creating input data...");
        float h_A[] = createRandomFloatData(nn);
        float h_B[] = createRandomFloatData(nn);
        float h_C[] = createRandomFloatData(nn);
        float h_C_ref[] = h_C.clone();
        
        sgemmJCublas(n, alpha, h_A, h_B, beta, h_C);
        
        
    }

    /**
     * Implementation of sgemm using JCublas
     */
    private static void sgemmJCublas(int n, float alpha, float A[], float B[],
                    float beta, float C[])
    {
        int nn = n * n;

        // Initialize JCublas
        JCublas.cublasInit();

        // Allocate memory on the device
        Pointer d_A = new Pointer();
        Pointer d_B = new Pointer();
        Pointer d_C = new Pointer();
        JCublas.cublasAlloc(nn, Sizeof.FLOAT, d_A);
        JCublas.cublasAlloc(nn, Sizeof.FLOAT, d_B);
        JCublas.cublasAlloc(nn, Sizeof.FLOAT, d_C);

        // Copy the memory from the host to the device
        JCublas.cublasSetVector(nn, Sizeof.FLOAT, Pointer.to(A), 1, d_A, 1);
        JCublas.cublasSetVector(nn, Sizeof.FLOAT, Pointer.to(B), 1, d_B, 1);
        JCublas.cublasSetVector(nn, Sizeof.FLOAT, Pointer.to(C), 1, d_C, 1);

        // Execute sgemm
        JCublas.cublasSgemm(
            'n', 'n', n, n, n, alpha, d_A, n, d_B, n, beta, d_C, n);

        // Copy the result from the device to the host
        JCublas.cublasGetVector(nn, Sizeof.FLOAT, d_C, 1, Pointer.to(C), 1);

        // Clean up
        JCublas.cublasFree(d_A);
        JCublas.cublasFree(d_B);
        JCublas.cublasFree(d_C);

        JCublas.cublasShutdown();
    }
    private static float[] createRandomFloatData(int n)
    {
        Random random = new Random();
        float x[] = new float[n];
        for (int i = 0; i < n; i++)
        {
            x[i] = random.nextFloat();
        }
        return x;
    }

}
