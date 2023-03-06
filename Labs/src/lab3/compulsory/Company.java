package lab3.compulsory;
import java.util.Map;
import java.util.HashMap;

class Company implements Nameable {
    private String name;
    private Map<Person, String> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public void addEmployee(Person employee, String position) {
        this.employees.put(employee, position);
    }

    @Override
    public String getName() {
        return this.name;
    }
}