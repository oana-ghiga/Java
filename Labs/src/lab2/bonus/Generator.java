package lab2.bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static ArrayList<Location> generateRandomLocations(int numLocations) {
        List<Location> locations = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numLocations; i++) {
            String name = "Location" + i;
            LocationType type = LocationType.values()[random.nextInt(LocationType.values().length)];
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            locations.add(new Location(name, type, x, y));
        }
        return (ArrayList<Location>) locations;
    }

    public static Graph generateRandomGraph(List<Location> locations, int numRoads, int maxRoadLength, int maxSpeedLimit) {
        Graph graph = new Graph();
        Random random = new Random();
        for (int i = 0; i < numRoads; i++) {
            Location start = locations.get(random.nextInt(locations.size()));
            Location end = locations.get(random.nextInt(locations.size()));
            if (start.equals(end)) {
                continue;
            }
            double distance = Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
            double length = random.nextDouble() * (maxRoadLength - distance) + distance;
            RoadType type = RoadType.values()[random.nextInt(RoadType.values().length)];
            double speedLimit = random.nextDouble() * maxSpeedLimit;
            Road road = new Road(type, start, end, speedLimit);
            graph.addRoad(road);
        }
        return graph;
    }

}
