package lab3.homework;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
public class Designer extends Person {
    private String tool;
    /**

     Constructs a designer with the given name, birth date, and design tool.
     @param name the name of the designer
     @param birthDate the birth date of the designer
     @param tool the design tool of the designer
     */
    public Designer(String name, Date birthDate, String tool) {
        super(name, birthDate);
        this.tool = tool;
    }
    /**

     Gets the design tool of the designer.
     @return the design tool of the designer
     */
    public String getTool() {
        return tool;
    }
    /**

     Sets the design tool of the designer.
     @param tool the design tool of the designer
     */
    public void setTool(String tool) {
        this.tool = tool;
    }
    /**

     Returns a string representation of the designer.
     @return a string representation of the designer
     */
    @Override
    public String toString() {
        return super.toString() + " - Designer (" + tool + ")";
    }
}
