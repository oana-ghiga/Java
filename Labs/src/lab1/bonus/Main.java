package lab1.bonus;

import java.util.Arrays;

import static lab1.bonus.RegularGraph.createRandRegGraph;
import static lab1.bonus.RegularGraph.printAdjMatrix;

public class Main {
    public static void main(String[] args) {
        CycleGraph cg = new CycleGraph(5);  // create cycle graph C5
        for (int i = 2; i <= 5; i++) {
            int[][] Ak = cg.power(i);
            System.out.println("A^" + i + ":");
            for (int[] row : Ak) {
                System.out.println(Arrays.toString(row));
            }
        }


// Test RegularGraph

        // parse the input arguments
        if (args.length < 2) {
            System.out.println("Usage: java RandRegGraph <vertNum> <deg>");
            return;
        }

        int vertNum = Integer.parseInt(args[0]);
        int deg = Integer.parseInt(args[1]);

        // create the random regular graph
        int[][] graph = createRandRegGraph(vertNum, deg);

        // print the adjacency matrix of the graph
        if (graph != null) {
            printAdjMatrix(graph);
        }
    }
}