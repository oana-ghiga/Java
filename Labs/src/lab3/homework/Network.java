package lab3.homework;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
public class Network {

    public List<Object> getNetwork() {
        return network;
    }

    //-> un array list de obiecte pt fiecare in parte gen programmer1, programmer2, programmer3, etc same for companies
    private static ArrayList<Object> nodes;
    private List<Object> network;
    /**
     * Constructs a network with an empty list of nodes.
     */
    public Network() {
        this.nodes = new ArrayList<>();
    }

    /**
     * Gets the list of nodes in the network.
     *
     * @return the list of nodes in the network
     */
    public static List<List<Object>> getNodes() {
        return (List) nodes;
    }

    /**
     * Adds a node to the list of nodes in the network.
     *
     * @param node the node to add to the list of nodes
     */
    public void addNode(Object node) {
        nodes.add(node);
    }

    /**
     * Computes the importance of a node in the network, defined as the number of its connections to other nodes.
     *
     * @param node the node whose importance is to be computed
     * @return the importance of the node in the network
     */
    public int computeImportance(Object node) {
        int importance = 0;
        if (node instanceof Person) {
            Person person = (Person) node;
            importance = person.getRelationships().size();
        } else if (node instanceof Company) {
            Company company = (Company) node;
            importance = company.getEmployees().size();
        }
        return importance;
    }

    /**
     * Prints the network on the screen, ordering the nodes according to their importance.
     */
    public void printNetwork() {
        // Sort the nodes according to their importance
        nodes.sort(Comparator.comparingInt(this::computeImportance).reversed());// this sorts the nodes in descending order

        // Print the nodes in order of importance
        for (Object node : nodes) {
            if (node instanceof Person) { // node instanceof Person
                Person person = (Person) node;
                System.out.println(person.getName() + " (" + computeImportance(person) + " connections)"); // this prints the name of the person and the number of connections
                Map<Person, String> relationships = person.getRelationships();
                if (!relationships.isEmpty()) {
                    System.out.println("  Person-to-person relationships:");
                    for (Map.Entry<Person, String> entry : relationships.entrySet()) {
                        System.out.println("    - " + entry.getKey().getName() + " (" + entry.getValue() + ")");
                    }
                }
                Company company = person.getEmployer();
                if (company != null) {
                    System.out.println("  Person-to-company relationship:");
                    System.out.println("    - " + company.getName() + " (" + company.getEmployees().get(person) + ")");
                }
            } else if (node instanceof Company) { // node instanceof Company
                Company company = (Company) node;
                System.out.println(company.getName() + " (" + computeImportance(company) + " employees)");// this prints the name of the company and the number of employees
                Map<Person, String> employees = company.getEmployees();
                if (!employees.isEmpty()) {
                    System.out.println("  Employees:");
                    for (Map.Entry<Person, String> entry : employees.entrySet()) {
                        System.out.println("    - " + entry.getKey().getName() + " (" + entry.getValue() + ")");
                    }
                }
            }
        }
    }
}
