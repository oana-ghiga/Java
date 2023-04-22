import com.github.javafaker.Faker;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class Main {

    public static void main(String[] args) {
// Create a Faker instance to generate student names
        Faker faker = new Faker();

        // Create a set of students and add some names using java-faker
        Set<Student> partition1 = new HashSet<>();
        int numStudents= 1000;
        for (int i = 0; i < numStudents; i++) {
            partition1.add(new Student(faker.name().firstName()));
        }

        // Create a set of projects and add some names using java-faker
        Set<Project> partition2 = new HashSet<>();
        int numProjects=1000;
        for (int i = 0; i < numProjects; i++) {
            partition2.add(new Project(faker.company().name()));
        }


        // Generate a random problem
        int maxAdmissible = 10;

        RandomGenerator randomGenerator = new RandomGenerator();
        BipartiteGraph<Student, Project> graph = randomGenerator.generateRandomProblem(numStudents, numProjects, maxAdmissible);

// Find maximum cardinality matching using Hopcroft-Karp algorithm
        HopcroftKarpMaximumCardinalityBipartiteMatching<Student, Project> hopcroftKarp = new HopcroftKarpMaximumCardinalityBipartiteMatching<>(graph, graph.getPartition1(), graph.getPartition2());

        long start = System.currentTimeMillis();
        MatchingAlgorithm.Matching<Student, Project> maxCardinalityMatching = hopcroftKarp.getMatching();
        long end = System.currentTimeMillis();
        System.out.println("Hopcroft-Karp: " + (end - start) + "ms");

        // Find maximum cardinality matching using greedy algorithm
        GreedyMatching<Student> greedyMatching = new GreedyMatching<>();
        start = System.currentTimeMillis();
        MatchingAlgorithm.Matching<Student, DefaultEdge> maxCardinalityMatchingGreedy = greedyMatching.findMaximumCardinalityMatching(graph);
        end = System.currentTimeMillis();
        System.out.println("Greedy: " + (end - start) + "ms");

        // Find minimum cardinality set
        Set<Student> minSet = graph.getMinimumCardinalitySet();
        Set<Project> minSetProject = graph.getMinimumCardinalitySetProject();

        // Find maximum cardinality set
        Set<Student> maxSet = graph.getMaximumCardinalitySet();
        Set<Project> maxSetProject = graph.getMaximumCardinalitySetProject();

        // Print results
        System.out.println("Maximum cardinality matching (Hopcroft-Karp):");
        for (DefaultEdge edge : maxCardinalityMatching.getEdges()) {
            Class<? extends Set> student = graph.getPartition1().getClass();
            Class<? extends Set> project = graph.getPartition2().getClass();
            System.out.println(student + " - " + project);
        }

        System.out.println("Maximum cardinality matching (greedy):");
        for (DefaultEdge edge : maxCardinalityMatchingGreedy.getEdges()) {
            Class<? extends Set> student = graph.getPartition1().getClass();
            Class<? extends Set> project = graph.getPartition2().getClass();
            System.out.println(student + " - " + project);
        }

        System.out.println("Minimum cardinality set:");
        System.out.println(minSet);
        System.out.println(minSetProject);

        System.out.println("Maximum cardinality set:");
        System.out.println(maxSet);
        System.out.println(maxSetProject);
    }

}
