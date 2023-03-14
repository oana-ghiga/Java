package lab4.src.main.java.compulsory;

import java.util.List;
import java.util.Set;


public class Student implements Comparable<Student> {
    private String name;
    private Set<Project> admissibleProjects;

    public Student(String name, Set<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    public String getName() {
        return name;
    }

    public Set<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
