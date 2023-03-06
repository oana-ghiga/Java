package lab3.compulsory;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Person riya = new Person("Riya");
        Person kazami = new Person("Kazami");
        Company airport = new Company("Airport");
        Company clothingStore = new Company("Clothing store");

        riya.addAcquaintance(kazami, "friend");
        kazami.addAcquaintance(riya, "friend");
        riya.setEmployment(airport, "engineer");
        kazami.setEmployment(clothingStore, "designer");
        airport.addEmployee(riya, "engineer");
        clothingStore.addEmployee(kazami, "designer");

        List<Nameable> nodes = new ArrayList<>();
        nodes.add(riya);
        nodes.add(kazami);
        nodes.add(airport);
        nodes.add(clothingStore);

        Collections.sort(nodes, (n1, n2) -> n1.getName().compareTo(n2.getName()));

        for (Nameable node : nodes) {
            System.out.println(node.getName());
        }
    }
}