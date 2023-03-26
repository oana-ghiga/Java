package bonus;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<Location, ArrayList<Road>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addLocation(Location location) {
        if (!adjacencyList.containsKey(location)) {
            adjacencyList.put(location, new ArrayList<>());
        }
    }

    public void addRoad(Road road) {
        addLocation(road.getFrom());
        addLocation(road.getTo());
        adjacencyList.get(road.getFrom()).add(road);
        adjacencyList.get(road.getTo()).add(road);
    }

    public ArrayList<Road> getAdjacentRoads(Location location) {
        return adjacencyList.getOrDefault(location, new ArrayList<>());
    }

    public Location getOppositeLocation(Location location, Road road) {
        if (road.getFrom().equals(location)) {
            return road.getTo();
        } else if (road.getTo().equals(location)) {
            return road.getFrom();
        } else {
            throw new IllegalArgumentException("Location not connected to road");
        }
    }

    public Road getRoadBetween(Location location1, Location location2) {
        for (Road road : adjacencyList.getOrDefault(location1, new ArrayList<>())) {
            if (road.getFrom().equals(location1) && road.getTo().equals(location2) || road.getFrom().equals(location2) && road.getTo().equals(location1)) {
                return road;
            }
        }
        throw new IllegalArgumentException("No road between locations");
    }
}