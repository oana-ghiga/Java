//main
//    public static void main(String[] args) {
//        // Create students and projects using streams
//        List<Student> students = Arrays.asList(
//                new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
//                new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))),
//                new Student("S2", Collections.singletonList(new Project("P0")))
//        );
//        Set<Project> projects = students.stream()
//                .flatMap(student -> student.getAdmissibleProjects().stream())
//                .collect(Collectors.toCollection(TreeSet::new));
//
//        // Put students in a LinkedList and print them sorted by name
//        LinkedList<Student> studentList = new LinkedList<>(students);
//        Collections.sort(studentList);
//        System.out.println("Students:");
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//        // Print students sorted by name
//        students.stream()
//                .sorted()
//                .forEach(student -> System.out.println(student.getName()));
//
//        // Print projects sorted by name
//        System.out.println("Projects:");
//        for (Project project : projects) {
//            System.out.println(project);
//
//        }
//    }
//}


//package lab4.src.main.java.compulsory;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;
//import java.util.stream.Collectors;
//public class Matching {
//    private Map<Student, List<Project>> students;
//    private Set<Project> projects;
//
//    public Matching(Map<Student, List<Project>> students, Set<Project> projects) {
//        this.students = students;
//        this.projects = projects;
//    }
//
//    public Set<Pair<Student, Project>> findMaximumMatching() {
//        Map<Student, Project> matching = new HashMap<>();
//        int maxMatching = 0;
//        while (bfs(matching)) {
//            for (Student student : students.keySet()) {
//                if (!matching.containsKey(student)) {
//                    if (dfs(student, matching)) {
//                        maxMatching++;
//                    }
//                }
//            }
//        }
//        return matching.entrySet()
//                .stream()
//                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
//                .collect(Collectors.toSet());
//    }
//
//    private boolean bfs(Map<Student, Project> matching) {
//        Queue<Student> queue = new LinkedList<>();
//        for (Student student : students.keySet()) {
//            if (!matching.containsKey(student)) {
//                student.setLevel(0);
//                queue.offer(student);
//            } else {
//                student.setLevel(Integer.MAX_VALUE);
//            }
//        }
//        boolean foundAugmentingPath = false;
//        while (!queue.isEmpty()) {
//            Student student = queue.poll();
//            for (Project project : students.get(student)) {
//                if (!projects.contains(project)) {
//                    continue;
//                }
//                Student otherStudent = project.getAssignedStudent();
//                if (otherStudent == null) {
//                    foundAugmentingPath = true;
//                    augmentPath(student, project, matching);
//                    break;
//                } else if (otherStudent.getLevel() == Integer.MAX_VALUE) {
//                    otherStudent.setLevel(student.getLevel() + 1);
//                    queue.offer(otherStudent);
//                }
//            }
//        }
//        return foundAugmentingPath;
//    }
//
//    private boolean dfs(Student student, Map<Student, Project> matching) {
//        for (Project project : students.get(student)) {
//            if (!projects.contains(project)) {
//                continue;
//            }
//            Student otherStudent = project.getAssignedStudent();
//            if (otherStudent == null || otherStudent.getLevel() == student.getLevel() + 1 && dfs(otherStudent, matching)) {
//                augmentPath(student, project, matching);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void augmentPath(Student student, Project project, Map<Student, Project> matching) {
//        project.setAssignedStudent(student);
//        matching.put(student, project);
//    }
//
//    public class Pair<T, T1> {
//    }
//}
//
