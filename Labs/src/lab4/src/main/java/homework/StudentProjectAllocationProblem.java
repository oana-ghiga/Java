//package lab4.src.main.java.homework;
//
//import java.util.*;
//
//public class StudentProjectAllocationProblem {
//
//    private final List<Student> students;
//    private final Set<Project> projects;
//
//    public StudentProjectAllocationProblem(List<Student> students, Set<Project> projects) {
//        this.students = students;
//        this.projects = projects;
//    }
//
//    /**
//     * Finds a maximum cardinality matching between students and projects.
//     * @return a set of pairs (student, project) representing the matching
//     */
//    public Set<Matching.Pair<Student, Project>> findMaxCardinalityMatching() {
//        return Matching.findMaxCardinalityMatching(students, projects);
//    }
//
//    /**
//     * Finds a greedy matching between students and projects.
//     * @return a set of pairs (student, project) representing the matching
//     */
//    public Set<Matching.Pair<Student, Project>> findGreedyMatching() {
//        return Matching.findGreedyMatching(students, projects);
//    }
//
//    /**
//     * Returns a stream of students that have a number of preferences lower than the average number of preferences.
//     * @return a stream of students
//     */
//    public Stream<Student> findStudentsWithFewPreferences() {
//        int avgPrefs = (int) students.stream().mapToInt(s -> s.getPreferences().size()).average().orElse(0);
//        return students.stream().filter(s -> s.getPreferences().size() < avgPrefs);
//    }
//
//    /**
//     * Returns a linked list of students sorted by their names.
//     * @return a linked list of students
//     */
//    public LinkedList<Student> getSortedStudents() {
//        LinkedList<Student> sorted = new LinkedList<>(students);
//        sorted.sort(Comparator.naturalOrder());
//        return sorted;
//    }
//
//    /**
//     * Returns a tree set of projects sorted by their names.
//     * @return a tree set of projects
//     */
//    public TreeSet<Project> getSortedProjects() {
//        return new TreeSet<>(projects);
//    }
//
//}