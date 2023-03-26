package bonus;
public class Location {
    private String name;
    private LocationType locationType;
    private int x;
    private int y;

    public Location(String name, LocationType locationType, int x, int y) {
        this.name = name;
        this.locationType = locationType;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) at (%d, %d)", name, locationType.name(), x, y);
    }

    public double distanceTo(Location end) {
        return Math.sqrt(Math.pow(x - end.x, 2) + Math.pow(y - end.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}