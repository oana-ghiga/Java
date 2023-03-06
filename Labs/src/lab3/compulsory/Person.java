package lab3.compulsory;
import java.util.Map;
import java.util.HashMap;

class Person implements Nameable {
    private String name;
    private Map<Person, String> acquaintances;
    private Company employer;
    private String position;

    public Person(String name) {
        this.name = name;
        this.acquaintances = new HashMap<>();
        this.employer = null;
        this.position = null;
    }

    public void addAcquaintance(Person person, String type) {
        this.acquaintances.put(person, type);
    }

    public void setEmployment(Company company, String position) {
        this.employer = company;
        this.position = position;
    }

    @Override
    public String getName() {
        return this.name;
    }
}