package lab4.src.main.java.homework;

public class Project implements Comparable<Project> {
    private final String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Project o) {
        return name.compareTo(o.name);
    }
}