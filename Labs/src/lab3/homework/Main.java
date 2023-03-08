package lab3.homework;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        // Create the network
        Network network = new Network();

        // Create some people
        Person alice = new Person("Alice", LocalDate.of(1990, 1, 1));
        Programmer bob = new Programmer("Bob", LocalDate.of(1995, 5, 1),"Java");
        Designer charlie = new Designer("Charlie", LocalDate.of(1992, 3, 1),"Python");
        Person dave = new Person("Dave", LocalDate.of(1985, 4, 1));
        Person eve = new Person("Eve", LocalDate.of(1988, 2, 1));

        // Create some companies
        Company google = new Company("Google", "Internet search");
        Company microsoft = new Company("Microsoft", "Computer software");
        Company apple = new Company("Apple", "Consumer electronics");

        // Add the nodes to the network
        network.addNode(alice);
        network.addNode(bob);
        network.addNode(charlie);
        network.addNode(dave);
        network.addNode(eve);
        network.addNode(google);
        network.addNode(microsoft);
        network.addNode(apple);

        // Define the relationships between the nodes
        alice.addRelationship(bob, "Friend");
        alice.setEmployer(google, "Software engineer");
        bob.addRelationship(charlie, "Coworker");
        bob.setEmployer(microsoft, "Programmer");
        charlie.setEmployer(apple, "Designer");
        dave.addRelationship(alice, "Family");
        eve.addRelationship(bob, "Coworker");
        eve.setEmployer(google, "Marketing");

        // Compute the importance of each node
        int importance = network.computeImportance(Network.getNodes());

        // Print the network sorted by importance
        network.printNetwork();
    }
}