package lab1.bonus;

/**
 * This class computes the powers of the adjacency matrix of a cycle graph Cn.
 */
public class CycleGraph {
    private int n;  // number of vertices in the cycle

    /**
     * Constructor for CycleGraph.
     * @param n number of vertices in the cycle
     */
    public CycleGraph(int n) {
        this.n = n;
    }

    /**
     * Computes the adjacency matrix of the cycle graph Cn.
     * @return the adjacency matrix of Cn
     */
    public int[][] adjacencyMatrix() {
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - j) % n == 1 || (j - i) % n == 1) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    /**
     * Computes the power of the adjacency matrix A of Cn.
     * @param k the exponent of the power
     * @return the adjacency matrix A^k
     */
    public int[][] power(int k) {
        int[][] A = adjacencyMatrix();
        int[][] Ak = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Ak[i][j] = A[i][j];
            }
        }
        for (int i = 2; i <= k; i++) {
            int[][] Atemp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        Atemp[j][l] += Ak[j][m] * A[m][l];
                    }
                }
            }
            Ak = Atemp;
        }
        return Ak;
    }
}

//public class CycleGraph {
//
//    public static void main(String[] args) {
//        int n = 5; // number of vertices in the cycle graph
//        int[][] A = new int[n][n]; // adjacency matrix for the cycle graph
//        for (int i = 0; i < n; i++) {
//            A[i][(i+1)%n] = 1; // connect vertex i with the next vertex in the cycle
//            A[(i+1)%n][i] = 1; // make the graph undirected
//        }
//        int[][] An = new int[n][n]; // matrix to store powers of A
//        An = A; // initialize A1 = A
//        for (int i = 2; i <= n; i++) {
//            An = matrixMultiplication(An, A); // compute An = A * An-1
//            System.out.println("A" + i + " = ");
//            printMatrix(An); // print An
//        }
//    }
//
//    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
//        int m = A.length;
//        int n = A[0].length;
//        int p = B[0].length;
//        int[][] C = new int[m][p];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < p; j++) {
//                for (int k = 0; k < n; k++) {
//                    C[i][j] += A[i][k] * B[k][j]; // matrix multiplication
//                }
//            }
//        }
//        return C;
//    }
//
//    public static void printMatrix(int[][] A) {
//        int m = A.length;
//        int n = A[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//}