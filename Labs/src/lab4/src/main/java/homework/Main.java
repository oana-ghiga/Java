package lab4.src.main.java.homework;

import com.github.javafaker.Faker;
import java.util.*;
import lab4.src.main.java.homework.Project;
import lab4.src.main.java.homework.Student;
import lab4.src.main.java.homework.StudentProjectAllocationProblem;
import lab4.src.main.java.homework.Matching;
import lab4.src.main.java.homework.greedyMatching;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Generate student and project names using Faker
        Faker faker = new Faker();

        List<Student> students = new LinkedList<>();
        Set<Project> projects = new TreeSet<>();

        // Create students with random names and project preferences
        for (int i = 0; i < 10; i++) {
            Student student = new Student(faker.name().fullName());
            student.addPreferences(new Project(faker.commerce().productName()));
            student.addPreferences(new Project(faker.commerce().productName()));
            student.addPreferences(new Project(faker.commerce().productName()));
            students.add(student);
        }

        // Create projects with random names
        for (int i = 0; i < 5; i++) {
            projects.add(new Project(faker.commerce().productName()));
        }

        // Print students and projects sorted by their names
        System.out.println("Students:");
        students.stream().sorted().forEach(System.out::println);
        System.out.println("\nProjects:");
        projects.stream().sorted().forEach(System.out::println);

        // Create the matching problem instance and solve it using greedy algorithm
        StudentProjectAllocationProblem problem = new StudentProjectAllocationProblem(students, projects);
        Matching greedyMatching = problem.greedyMatching();

        // Print the solution
        System.out.println("\nGreedy matching solution:");
        for (Pair<Student, Project> pair : greedyMatching.getPairs()) {
            System.out.println(pair.getLeft().getName() + " - " + pair.getRight().getName());
        }

        // Use Java Stream API to display students with fewer preferences than the average
        double avgPreferences = students.stream()
                .mapToInt(student -> student.getPreferences().size())
                .average()
                .orElse(0);

        System.out.println("\nStudents with fewer preferences than the average (" + avgPreferences + "):");
        students.stream()
                .filter(student -> student.getPreferences().size() < avgPreferences)
                .sorted()
                .forEach(System.out::println);
    }
}