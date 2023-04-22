package lab3.bonus.homework;

import java.time.LocalDate;

public class Programmer extends Person {
    private String language;

    /**
     * Constructs a programmer with the given name, birth date, and language.
     *
     * @param name the name of the programmer
     * @param birthDate the birth date of the programmer
     * @param language the programming language of the programmer
     */
    public Programmer(String name, LocalDate birthDate, String language) {
        super(name, birthDate);
        this.language = language;
    }

    /**
     * Gets the programming language of the programmer.
     *
     * @return the programming language of the programmer
     */
    public String getLanguage() {
        return language;
    }
    /**
     * Sets the programming language of the programmer.
     *
     * @param language the programming language of the programmer
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Returns a string representation of the programmer.
     *
     * @return a string representation of the programmer
     */
    @Override
    public String toString() {
        return super.toString() + " - Programmer (" + language + ")";
    }
}
