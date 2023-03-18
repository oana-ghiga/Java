package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Project[] projects = Utilities.createProjects();
        Student[] students = Utilities.createStudents(projects);

        Utilities.createStudentList(students);
        Utilities.createProjectTreeSet(projects);
        Student[] lowPreferencesStudents = Utilities.lowPreferencesStudents(students);
        System.out.println("Students with low preferences: ");
        Utilities.printStudents(lowPreferencesStudents);

        Problem problem = new Problem(students, projects);
        Pair<Integer, Matching> result = problem.solve();
        System.out.println("Maximum matching: " + result.getKey());
        System.out.println("Assigned projects: ");
        result.getValue().getAssignedProjects().forEach((student, project) -> System.out.println(student.getName() + "-" + project.getName()));

        Project[] randomProjects = Utilities.createRandomProjects();
        Student[] randomStudents = Utilities.createRandomStudents(randomProjects);

        System.out.println("Random projects: ");
        Arrays.stream(randomProjects).forEach(project -> System.out.print(project.getName() + " "));
        System.out.println();
        System.out.println("Random students: ");
        Arrays.stream(randomStudents).forEach(student -> System.out.print(student.getName() + " "));

        Problem randomProblem = new Problem(randomStudents, randomProjects);
        Pair<Integer, Matching> randomResult = randomProblem.solve();
        System.out.println("Maximum matching: " + randomResult.getKey());
        System.out.println("Assigned projects: ");
        randomResult.getValue().getAssignedProjects().forEach((student, project) -> System.out.println(student.getName() + "-" + project.getName()));
    }
}
