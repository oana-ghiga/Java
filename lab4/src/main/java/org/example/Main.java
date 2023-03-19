package org.example;

import java.util.*;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;

public class Main {
    public static void main(String[] args) {
        Project[] projects = Utilities.createProjects();
        Student[] students = Utilities.createStudents(projects);

        Utilities.createStudentList(students);
        Utilities.createProjectTreeSet(projects);
        List<Student> lowPreferencesStudents = new ArrayList<>(Arrays.asList(Utilities.lowPreferencesStudents(students)));
        System.out.println("Students with low preferences: ");
        lowPreferencesStudents.forEach(System.out::println);

        Problem problem = new Problem(Arrays.asList(students), new TreeSet<>(Arrays.asList(projects)));
        Set<Pair<Student, Project>> matching = problem.generateMatching();
        System.out.println("Maximum matching size: " + matching.size());
        System.out.println("Assigned projects: ");
        matching.forEach(pair -> System.out.println(pair.getKey().getName() + "-" + pair.getValue().getName()));

        // Generate random students and projects
        Faker faker = new Faker();
        Project[] randomProjects = Utilities.createRandomProjects(faker);
        Student[] randomStudents = Utilities.createRandomStudents(randomProjects, faker);

        System.out.println("Random projects: ");
        Arrays.stream(randomProjects).forEach(project -> System.out.print(project.getName() + " "));
        System.out.println();
        System.out.println("Random students: ");
        Arrays.stream(randomStudents).forEach(student -> System.out.print(student.getName() + " "));

        Problem randomProblem = new Problem(Arrays.asList(randomStudents), new TreeSet<>(Arrays.asList(randomProjects)));
        matching = randomProblem.generateMatching();
        System.out.println("Maximum matching size: " + matching.size());
        System.out.println("Assigned projects: ");
        matching.forEach(pair -> System.out.println(pair.getKey().getName() + "-" + pair.getValue().getName()));
    }
}