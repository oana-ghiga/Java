package lab2.homework;

public class Location {
    private String name;
    private String type;
    private double x;
    private double y;

    public Location(String name, String type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Compares this location with another object for equality.
     * Two locations are equal if they have the same name, type, and coordinates.
     *
     * @param o the object to compare with
     * @return true if this location is equal to the other object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        Location other = (Location) o;
        return this.name.equals(other.name) && this.type.equals(other.type)
                && this.x == other.x && this.y == other.y;
    }

    // getters and setters
}

