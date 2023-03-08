package lab3.homework;
import java.util.*;
import java.util.HashMap;
public class Company implements Comparable{
    private String name;
    private Map<Person, String> employees; // Person-to-company relationships
    private String specificProperty;
    /**

     Constructs a company with the given name.
     @param name the name of the company
     */
    public Company(String name,String specificProperty){
        this.name = name;
        this.employees = new HashMap<>();
        this.specificProperty = specificProperty;
    }
    /**

     Gets the name of the company.
     @return the name of the company
     */
    public String getName() {
        return name;
    }
    /**

     Gets the map of person-to-company relationships.
     @return the map of person-to-company relationships
     */
    public Map<Person, String> getEmployees() {
        return employees;
    }
    /**

     Gets the specific property of the company.
     @return the specific property of the company
     */
    public String getSpecificProperty() {
        return specificProperty;
    }
    /**

     Sets the specific property of the company.
     @param specificProperty the specific property of the company
     */
    public void setSpecificProperty(String specificProperty) {
        this.specificProperty = specificProperty;
    }
    /**

     Adds a person-to-company relationship to the map of employees.
     @param person the person who works for the company
     @param position the position of the person at the company
     */
    public void addEmployee(Person person, String position) {
        employees.put(person, position);
    }
    /**

     Returns a string representation of the company.
     @return a string representation of the company
     */
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
