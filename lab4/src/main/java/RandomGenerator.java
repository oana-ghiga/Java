import org.jgrapht.graph.DefaultEdge;

import java.util.Set;
import java.util.HashSet;
import com.github.javafaker.Faker;

public class RandomGenerator {
    private Set<Student> partition1;
    private Set<Project> partition2;
    private double density;

    public RandomGenerator() {
        // Create a Faker instance to generate student names
        Faker faker = new Faker();

        // Create a set of students and add some names using java-faker
        partition1 = new HashSet<>();
        int numStudents= 10;
        for (int i = 0; i < numStudents; i++) {
            partition1.add(new Student(faker.name().firstName()));
        }

        // Create a set of projects and add some names using java-faker
        partition2 = new HashSet<>();
        int numProjects=10;
        for (int i = 0; i < numProjects; i++) {
            partition2.add(new Project(faker.company().name()));
        }

        // Set the desired density of the graph
        this.density = density;
    }

    public BipartiteGraph<Student, Project> generateRandomProblem(int numStudents, int numProjects, int maxAdmissible) {
        BipartiteGraph<Student, Project> graph = new BipartiteGraph<>(DefaultEdge.class);

        // Add vertices and edges to the graph based on the desired density
        for (Student student : partition1) {
            for (Project project : partition2) {
                if (Math.random() < density) {
                    graph.addVertex(student);
                    graph.addVertexToPartition2(project);
                    graph.addEdge(student, project);
                }
            }
        }

        return graph;
    }
}
