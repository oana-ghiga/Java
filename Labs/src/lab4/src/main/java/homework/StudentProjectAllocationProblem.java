//package lab4.src.main.java.compulsory;
//import java.util.*;
//import java.util.stream.Collectors;
//public class StudentProjectAllocationProblem {
//        private final List<Student> students;
//        private final Set<Project> projects;
//
//        public StudentProjectAllocationProblem(List<Student> students, Set<Project> projects) {
//            this.students = students;
//            this.projects = projects;
//        }
//
//        public List<Student> getStudents() {
//            return students;
//        }
//
//        public Set<Project> getProjects() {
//            return projects;
//        }
//
//        public Set<Matching.Pair<Student, Project>> findMaximumMatching() {
//            Matching matching = new Matching(students.stream().collect(Collectors.toMap(student -> student, Student::getAdmissibleProjects)), projects);
//            return matching.findMaximumMatching();
//        }
//    }
