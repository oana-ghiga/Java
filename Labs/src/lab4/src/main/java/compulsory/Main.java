package lab4.src.main.java.compulsory;
//import lab4.src.main.java.compulsory.Matching;
import lab4.src.main.java.compulsory.Project;
import lab4.src.main.java.compulsory.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // create the students and projects
        Student s0 = new Student("Sam", Stream.of(new Project("give"), new Project("never"), new Project("gonna")).collect(Collectors.toSet()));
        Student s1 = new Student("Lone", Stream.of(new Project("gonna"), new Project("up")).collect(Collectors.toSet()));
        Student s2 = new Student("Will", Stream.of(new Project("never")).collect(Collectors.toSet()));

        // put the students in a LinkedList and print them sorted
        List<Student> students = new LinkedList<>(Arrays.asList(s0, s1, s2));
        students.sort(null); // uses the natural ordering (i.e. compareTo)
        System.out.println("Students sorted by name:");
        students.forEach(System.out::println);

        // put the projects in a TreeSet and print them sorted
        Set<Project> projects = Stream.of(s0, s1, s2)
                .flatMap(s -> s.getAdmissibleProjects().stream())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Projects sorted by name:");
        projects.forEach(System.out::println);
    }
}