package lab1.bonus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegularGraph {

    /**
     * @param vertNum - number of vertices
     * @param deg     - the degree of each vertex
     * @return A - A sparse matrix representation of the graph
     * <p>
     * algorithm : "The pairing model" : create n*d 'half edges'.
     * repeat as long as possible: pick a pair of half edges
     * and if it's legal (doesn't create a loop nor a double edge)
     * add it to the graph
     * reference: http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.67.7957&rep=rep1&type=pdf
     */
    public static int[][] createRandRegGraph(int vertNum, int deg) {
        int n = vertNum;
        int d = deg;
        int matIter = 10;
        int[][] A = new int[n][n]; // adjacency matrix

        if (n <= 0 || d <= 0) {
            System.err.println("createRandRegGraph input err: vertNum and deg must be positive");
            return null;
        }
        //check parameters
        if ((n * d) % 2 == 1) {
            System.out.println("createRandRegGraph input err: n*d must be even!");
            return null;
        }

        //a list of open half-edges
        List<Integer> U = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < d; j++) {
                U.add(i);
            }
        }

        //the graphs adjacency matrix
        int edgesTested = 0;
        int repetition = 1;

        //continue until a proper graph is formed
        while (!U.isEmpty() && repetition < matIter) {
            edgesTested++;

            //print progress
            if (edgesTested % 5000 == 0) {
                System.out.printf("createRandRegGraph() progress: edges=%d/%d\n", edgesTested, n * d);
            }

            //choose at random 2 half edges
            Random rand = new Random();
            int i1 = rand.nextInt(U.size());
            int i2 = rand.nextInt(U.size());
            int v1 = U.get(i1);
            int v2 = U.get(i2);

            //check that there are no loops nor parallel edges
            if (v1 == v2 || A[v1 - 1][v2 - 1] == 1) {
                //restart process if needed
                if (edgesTested == n * d) {
                    repetition++;
                    edgesTested = 0;
                    U = new ArrayList<Integer>();
                    for (int i = 1; i <= n; i++) {
                        for (int j = 0; j < d; j++) {
                            U.add(i);
                        }
                    }
                    A = new int[n][n];
                }
            } else {
                //add edge to graph
                A[v1 - 1][v2 - 1] = 1;
                A[v2 - 1][v1 - 1] = 1;

                //remove used half-edges
                int[] indicesToRemove = new int[2];
                indicesToRemove[0] = Math.min(i1, i2);
                indicesToRemove[1] = Math.max(i1, i2) - 1;
                Arrays.sort(indicesToRemove);
                U.remove(indicesToRemove[1]);
                U.remove(indicesToRemove[0]);
            }
        }
        return A;
    }

    public static void printAdjMatrix(int[][] A) {
        if (A == null) {
            System.out.println("printAdjMatrix input err: adjacency matrix is null");
            return;
        }

        int n = A.length;

        System.out.println("Graph adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}