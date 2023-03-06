package lab3.homework;
import java.util.*;
import java.util.Date;
import java.util.HashMap;

public class Person {
    private String name;
    private Date birthDate;
    private Map<Person, String> relationships; // Person-to-person relationships
    private Map<Company, String> employment; // Person-to-company relationships
    private int specificProperty;
    private Company employer;

    /**
     * Constructs a person with the given name and birth date.
     *
     * @param name the name of the person
     * @param birthDate the birth date of the person
     */
    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<>();
        this.employment = new HashMap<>();
        this.specificProperty = 0;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the birth date of the person.
     *
     * @return the birth date of the person
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Gets the map of person-to-person relationships.
     *
     * @return the map of person-to-person relationships
     */
    public Map<Person, String> getRelationships() {
        return relationships;
    }

    /**
     * Gets the map of person-to-company relationships.
     *
     * @return the map of person-to-company relationships
     */
    public Map<Company, String> getEmployment() {
        return employment;
    }

    /**
     * Gets the specific property of the person.
     *
     * @return the specific property of the person
     */
    public int getSpecificProperty() {
        return specificProperty;
    }

    /**
     * Sets the specific property of the person.
     *
     * @param specificProperty the specific property of the person
     */
    public void setSpecificProperty(int specificProperty) {
        this.specificProperty = specificProperty;
    }

    /**
     * Adds a person-to-person relationship to the map of relationships.
     *
     * @param person the person to add a relationship with
     * @param relationship the type of relationship with the person
     */
    public void addRelationship(Person person, String relationship) {
        relationships.put(person, relationship);
    }

    /**
     * Adds a person-to-company relationship to the map of employment.
     *
     * @param company  the company the person is employed at
     * @param position the position of the person at the company
     * @return
     */
    public Company getEmployer(Company company, String position) {
        employment.put(company, position);
        return company;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return name + " (born " + birthDate + ")";
    }

    public Company getEmployer() {
        return employer;
    }
}

