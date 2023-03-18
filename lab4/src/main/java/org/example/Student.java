package org.example;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissableProjects;

    public Student(String name, List<Project> admissableProjects) {
        this.name = name;
        this.admissableProjects = admissableProjects;
    }

    public String getName() {
        return name;
    }

    public List<Project> getAdmissableProjects() {
        return admissableProjects;
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }
}
