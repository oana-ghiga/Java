package bonus;
import java.util.ArrayList;

public class Route {
    private ArrayList<Location> locations;
    private ArrayList<Road> roads;

    public Route(ArrayList<Location> locations, ArrayList<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public double getLength() {
        double length = 0.0;
        for (Road road : roads) {
            length += road.getLength();
        }
        return length;
    }

    public double getTime() {
        double time = 0.0;
        for (Road road : roads) {
            time += road.getLength() / road.getSpeedLimit();
        }
        return time;
    }
}