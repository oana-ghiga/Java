//package lab3.homework;
//import java.time.LocalDate;
//import java.util.*;
//import java.util.Date;
//import java.util.HashMap;
//
//
//
//public class Main {
//    public static void main(String[] args) {
//        // Create the network
//        Network network = new Network();
//
//        // Create some people
//        Person alice = new Person("Alice", LocalDate.of(1990, Month.JANUARY, 1));
//        Programmer bob = new Programmer("Bob", LocalDate.of(1995, Month.FEBRUARY, 1));
//        Designer charlie = new Designer("Charlie", LocalDate.of(1992, Month.MARCH, 1));
//        Person dave = new Person("Dave", LocalDate.of(1985, Month.APRIL, 1));
//        Person eve = new Person("Eve", LocalDate.of(1988, Month.MAY, 1));
//
//        // Create some companies
//        Company google = new Company("Google", "Internet search");
//        Company microsoft = new Company("Microsoft", "Computer software");
//        Company apple = new Company("Apple", "Consumer electronics");
//
//        // Add the nodes to the network
//        network.addNode(alice);
//        network.addNode(bob);
//        network.addNode(charlie);
//        network.addNode(dave);
//        network.addNode(eve);
//        network.addNode(google);
//        network.addNode(microsoft);
//        network.addNode(apple);
//
//        // Define the relationships between the nodes
//        alice.addPersonRelationship(bob, "Friend");
//        alice.setEmployer(google, "Software engineer");
//        bob.addPersonRelationship(charlie, "Coworker");
//        bob.setEmployer(microsoft, "Programmer");
//        charlie.setEmployer(apple, "Designer");
//        dave.addPersonRelationship(alice, "Family");
//        eve.addPersonRelationship(bob, "Coworker");
//        eve.setEmployer(google, "Marketing");
//
//        // Compute the importance of each node
//        Map<Node, Integer> importance = network.computeNodeImportance();
//
//        // Print the network sorted by importance
//        network.printNetworkSorted(importance);
//    }
//}