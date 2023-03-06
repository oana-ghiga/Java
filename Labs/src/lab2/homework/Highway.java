package lab2.homework;

/**
 * Represents a highway road in the Best Route Problem.
 */
public class Highway extends Road {
    public Highway(String type, double length, double speedLimit, Location start, Location end) {
        super("Highway", length, speedLimit, start, end);
    }
}