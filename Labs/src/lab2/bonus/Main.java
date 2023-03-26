package bonus;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // create some example locations
        Location loc1 = new Location("New York", LocationType.CITY, 0, 0);
        Location loc2 = new Location("Boston", LocationType.CITY, 0, 5);
        Location loc3 = new Location("Washington", LocationType.CITY, 5, 0);
        Location loc4 = new Location("Philadelphia", LocationType.CITY, 3, 3);
        Location loc5 = new Location("Chicago", LocationType.CITY, 10, 10);

        // create some example roads
        Road road1 = new Road(RoadType.HIGHWAY, loc1, loc2,10);
        Road road2 = new Road(RoadType.COUNTRY, loc2, loc4,15);
        Road road3 = new Road(RoadType.EXPRESS, loc3, loc5,20);

        // create a graph and add the locations and roads to it
        Graph graph = new Graph();
        graph.addLocation(loc1);
        graph.addLocation(loc2);
        graph.addLocation(loc3);
        graph.addLocation(loc4);
        graph.addLocation(loc5);
        graph.addRoad(road1);
        graph.addRoad(road2);
        graph.addRoad(road3);
        graph.addRoad(road1);
        graph.addRoad(road3);

        // test performance of the algorithm on example graph
        PerformanceAnalyzer.analyzePerformance(loc1, loc5);
        // generate a random instance of the problem
        List<Location> locations = Generator.generateRandomLocations(10);
        Graph randomGraph = Generator.generateRandomGraph(locations, 20, 100, 120);
        Location from = locations.get(0);
        Location to = locations.get(1);
        PerformanceAnalyzer.analyzePerformance(from, to);

        // generate a random instance of the problem with no best route
        ArrayList<Location> noRouteLocations = Generator.generateRandomLocations(5);
        Graph noRouteGraph = Generator.generateRandomGraph(noRouteLocations, 0, 0, 0);
        Location fromNoRoute = noRouteLocations.get(0);
        Location toNoRoute = noRouteLocations.get(1);
        PerformanceAnalyzer.analyzePerformance(fromNoRoute, toNoRoute);

        // generate a random instance of the problem with only one fastest route
        ArrayList<Location> oneFastestRouteLocations = Generator.generateRandomLocations(6);
        Graph oneFastestRouteGraph = Generator.generateRandomGraph(oneFastestRouteLocations, 1, 10, 10);
        Location fromFastest = oneFastestRouteLocations.get(0);
        Location toFastest = oneFastestRouteLocations.get(1);
        Road fastestRoad = new Road(RoadType.HIGHWAY, loc1, loc2, 5);
        oneFastestRouteGraph.addRoad(fastestRoad);
        PerformanceAnalyzer.analyzePerformance(fromFastest, toFastest);

        // generate a random instance of the problem with only one shortest route
        ArrayList<Location> oneShortestRouteLocations = Generator.generateRandomLocations(6);
        Graph oneShortestRouteGraph = Generator.generateRandomGraph(oneShortestRouteLocations, 1, 10, 10);
        Location fromShortest = oneShortestRouteLocations.get(0);
        Location toShortest = oneShortestRouteLocations.get(1);
        Road shortestRoad = new Road(RoadType.EXPRESS, loc3, loc5, 10);
        oneShortestRouteGraph.addRoad(shortestRoad);
        PerformanceAnalyzer.analyzePerformance(fromShortest, toShortest);
    }
}