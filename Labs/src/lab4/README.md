PLS IGNORE THE HOMEWORK IN LAB 4, MADE A NEW FOLDER WITH A NEW PROJECT CAUSE HERE IT WASN'T WORKING



The Student-Project Allocation Problem
An instance of this problem consists of students and projects. Each student has a list of projects that are admissible.
A matching is a set of pairs (student, project) such that each student is assigned to at most one project and each project is assigned to at most one student. We consider the problem of creating a maximum cardinality matching between students and projects.

Example: 3 students (S0,S1,S2) and 3 projects (P0,P1,P2).
Projects considered admissible by: S0={P0,P1,P2}, S1={P0,P1}, S2={P0}.
The maximum cardinality matching should be: {S0-P2, S1-P1, S2-P0}.

The main specifications of the application are:

Compulsory (1p)

Create a Maven project.
Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.
Create the students and the projects described in the example. Use streams in order to easily create the objects.
Put all the students in a LinkedList and print them sorted by their names.
Put all the projects in a TreeSet and print them sorted by their names.
Homework (2p)
Create a class that describes the problem.
Using Java Stream API, write a query that display all the students that have a number of preferences lower than the average number of preferences.
Use a third-party library in order to generate random fake names for students and projects.
Create a Greedy algorithm in order to solve the problem.
Bonus (2p)
Implement an algorithm that determines the maximum cardinality matching
... or you may use the following libraries in order to solve it:
JGraphT
Graph4J
Create a random problem generator (with thousands of objects) and test the performance of the implementation (try both libraries).
Compare the results with the ones obtained by the greedy algorithm.
Determine a minimum cardinality set formed of students and projects with the property that each admissible pair (student-project) contains at least an element of this set.
Determine a maximum cardinality set of of students and projects such that there is no admissible pair (student-project) formed with elements of this set.