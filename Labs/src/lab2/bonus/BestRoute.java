package bonus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BestRoute {
    static Graph graph = new Graph();


    public static Route getFastestRoute(Location start, Location end) {
        // Dijkstra's algorithm
        HashMap<Location, Double> distances = new HashMap<>();
        HashMap<Location, Location> predecessors = new HashMap<>();
        PriorityQueue<Location> unvisited = new PriorityQueue<>((l1, l2) -> Double.compare(distances.getOrDefault(l1, Double.POSITIVE_INFINITY), distances.getOrDefault(l2, Double.POSITIVE_INFINITY)));

        distances.put(start, 0.0);
        unvisited.offer(start);

        while (!unvisited.isEmpty()) {
            Location current = unvisited.poll();
            if (current.equals(end)) {
                break;
            }

            for (Road road : graph.getAdjacentRoads(current)) {
                Location neighbor = graph.getOppositeLocation(current, road);
                double distanceToNeighbor = distances.getOrDefault(current, Double.POSITIVE_INFINITY) + road.getLength() / road.getSpeedLimit();
                if (distanceToNeighbor < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, distanceToNeighbor);
                    predecessors.put(neighbor, current);
                    unvisited.offer(neighbor);
                }
            }
        }

        ArrayList<Location> locations = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();

        Location current = end;
        while (predecessors.containsKey(current)) {
            locations.add(0, current);
            Location predecessor = predecessors.get(current);
            roads.add(0, graph.getRoadBetween(current, predecessor));
            current = predecessor;
        }
        locations.add(0, start);

        return new Route(locations, roads);
    }

    public static Route getShortestRoute(Location start, Location end) {
        // Dijkstra's algorithm
        HashMap<Location, Double> distances = new HashMap<>();
        HashMap<Location, Location> predecessors = new HashMap<>();
        PriorityQueue<Location> unvisited = new PriorityQueue<>((l1, l2) -> Double.compare(distances.getOrDefault(l1, Double.POSITIVE_INFINITY), distances.getOrDefault(l2, Double.POSITIVE_INFINITY)));

        distances.put(start, 0.0);
        unvisited.offer(start);

        while (!unvisited.isEmpty()) {
            Location current = unvisited.poll();
            if (current.equals(end)) {
                break;
            }

            for (Road road : graph.getAdjacentRoads(current)) {
                Location neighbor = graph.getOppositeLocation(current, road);
                double distanceToNeighbor = distances.getOrDefault(current, Double.POSITIVE_INFINITY) + road.getLength();
                if (distanceToNeighbor < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, distanceToNeighbor);
                    predecessors.put(neighbor, current);
                    unvisited.offer(neighbor);
                }
            }
        }

        ArrayList<Location> locations = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();

        Location current = end;
        while (predecessors.containsKey(current)) {
            locations.add(0, current);
            Location predecessor = predecessors.get(current);
            roads.add(0, graph.getRoadBetween(current, predecessor));
            current = predecessor;
        }
        locations.add(0, start);

        return new Route(locations, roads);
    }
}