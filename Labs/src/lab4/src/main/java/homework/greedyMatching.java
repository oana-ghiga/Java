package lab4.src.main.java.homework;

import java.util.*;

public class greedyMatching {
    public static Matching solve(Student[] students, Project[] projects) {
        // Sort students by number of preferences
        List<Student> sortedStudents = new ArrayList<>(Arrays.asList(students));
        sortedStudents.sort(Comparator.comparingInt(s -> s.getPreferences().size()));

        // Sort projects by number of admissible students
        List<Project> sortedProjects = new ArrayList<>(Arrays.asList(projects));
        sortedProjects.sort(Comparator.comparingInt(p -> p.getAdmissibleStudents().size()));

        // Create empty matching
        Matching matching = new Matching();

        // Iterate over students in order of increasing number of preferences
        for (Student student : sortedStudents) {
            // Find first project in the list of preferences that is not already assigned
            Project project = student.getPreferences().stream()
                    .filter(p -> !matching.getPairs().stream().anyMatch(pair -> pair.getValue().equals(p)))
                    .findFirst().orElse(null);

            // If such a project exists, add the pair to the matching
            if (project != null) {
                matching.addPair(student, project);
            } else {
                // If not, find the project with the fewest admissible students that is not already assigned
                project = sortedProjects.stream()
                        .filter(p -> !matching.getPairs().stream().anyMatch(pair -> pair.getValue().equals(p)))
                        .findFirst().orElse(null);

                // If such a project exists, add the pair to the matching
                if (project != null) {
                    matching.addPair(student, project);
                }
            }
        }

        return matching;
    }
}