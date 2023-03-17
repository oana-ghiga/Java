package lab4.src.main.java.homework;

import java.util.HashSet;
import java.util.Set;

public class Matching {
    private final Set<Pair<Student, Project>> pairs;

    public Matching() {
        this.pairs = new HashSet<>();
    }

    public void addPair(Student student, Project project) {
        pairs.add(new Pair<>(student, project));
    }

    public Set<Pair<Student, Project>> getPairs() {
        return pairs;
    }

    public class Pair<T, T1> {
        public Pair(T student, T1 project) {
        }
    }
}