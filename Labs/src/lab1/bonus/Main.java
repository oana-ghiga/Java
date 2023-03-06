//package lab1.bonus;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
///**
// * Example main class that creates and computes the powers of a cycle graph and a regular graph.
// */
//public class Main {
//
//    public static void main(String[] args) {
////        int n = 6; // number of vertices in the cycle graph
////        int d = 3; // degree of each vertex in the regular graph
//       int n = Integer.parseInt(args[0]);
//       int d = Integer.parseInt(args[1]);
//
//        // create adjacency matrix of cycle graph
//        int[][] cycleGraph = createCycleGraph(n);
//
//        // compute powers of adjacency matrix of cycle graph
//        int[][] A = cycleGraph;
//        for (int i = 2; i <= n; i++) {
//            A = matrixMultiply(A, cycleGraph);
//            System.out.println("A" + i + ":");
//            printMatrix(A);
//        }
//
//        // create adjacency matrix of regular graph
//        int[][] regularGraph = createRegularGraph(n, d);
//
//        System.out.println("Adjacency matrix of regular graph:");
//        printMatrix(regularGraph);
//    }
//
//    /**
//     * Creates the adjacency matrix of a cycle graph Cn with n vertices.
//     * @param n The number of vertices in the cycle graph.
//     * @return The adjacency matrix of the cycle graph.
//     */
//    public static int[][] createCycleGraph(int n) {
//        int[][] A = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            A[i][(i+1) % n] = 1;
//            A[(i+1) % n][i] = 1;
//        }
//        return A;
//    }
//
//    /**
//     * Creates the adjacency matrix of a regular graph with n vertices and vertex degree d.
//     * @param n The number of vertices in the regular graph.
//     * @param d The degree of each vertex in the regular graph.
//     * @return The adjacency matrix of the regular graph.
//     */
//    public static int[][] createRegularGraph(int n, int d) {
////        int[][] A = new int[n][n];
////        for (int i = 0; i < n; i++) {
////            for (int j = i+1; j < n && j-i <= d/2; j++) {
////                regula[i][j] = 1;
////                A[j][i] = 1;
////            }
////        }
////        return A;
////    }
//
//
//    /**
//     * Multiplies two matrices A and B and returns the result C = A * B.
//     * Assumes that A and B are square matrices of the same size.
//     * @param A The first matrix to multiply.
//     * @param B The second matrix to multiply.
//     * @return The product of A and B.
//     */
//    public static int[][] matrixMultiply(int[][] A, int[][] B) {
//        int n = A.length;
//        int[][] C = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    C[i][j] += A[i][k] * B[k][j];
//                }
//            }
//        }
//        return C;
//    }
//
///**
// * Prints a matrix to the console.
// * @param A The matrix to print.
//    */
//        public static void printMatrix(int[][] A) {
//            for (int i = 0; i < A.length; i++) {
//                for (int j = 0; j < A[i].length; j++) {
//                    System.out.print(A[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }}
//

