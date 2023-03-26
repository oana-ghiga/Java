//package lab2.homework;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BestRouteProblem {
//    private List<Location> locations;
//    private List<Road> roads;
//
//    public BestRouteProblem() {
//        locations = new ArrayList<>();
//        roads = new ArrayList<>();
//    }
//    public List<Location> getLocations() {
//        return locations;
//    }
//
//    public List<Road> getRoads() {
//        return roads;
//    }
//
//    public boolean addLocation(Location location) {
//        if (locations.contains(location)) {
//            return false;
//        }
//        locations.add(location);
//        return true;
//    }
//
//    public boolean addRoad(Road road) {
//        if (roads.contains(road)) {
//            return false;
//        }
//        if (road.getStart() == null || road.getEnd() == null || !locations.contains(road.getStart()) || !locations.contains(road.getEnd())) {
//            return false;
//        }
//        roads.add(road);
//        return true;
//    }
//
//    /**
//     * Determines if this problem instance is valid.
//     * A problem is valid if all roads are at least as long as the Euclidean distance
//     * between their endpoints.
//     *
//     * @return true if this problem is valid, false otherwise
//     */
//    public boolean isValid() {
//        for (Road road : roads) {
//            double distance = calculateDistance(road);
//            if (distance> road.getLength()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Calculates the Euclidean distance between the endpoints of a road.
//     *
//     * @param road the road to calculate the distance for
//     * @return the Euclidean distance between the endpoints of the road
//     */
//    private double calculateDistance(Road road) {
//        // assume the endpoints are the first two locations in the list
//        Location start = locations.get(0);
//        Location end = locations.get(1);
//        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2)
//                + Math.pow(end.getY() - start.getY(), 2));
//    }
//
//    /**
//     * Determines if it is possible to go from one location to another using the given roads.
//     * A route is possible if there exists a sequence of roads that connects the two locations.
//     *
//     * @param start the starting location
//     * @param end the ending location
//     * @return true if a route is possible, false otherwise
//     */
//    public boolean isRoutePossible(Location start, Location end) {
//        // check if start and end locations are in the problem instance
//        if (!locations.contains(start) || !locations.contains(end)) {
//            return false;
//        }
//
//        // check if there is a road that connects the start and end locations
//        for (Road road : roads) {
//            if ((roadStart(road).equals(start) && roadEnd(road).equals(end))
//                    || (roadStart(road).equals(end) && roadEnd(road).equals(start))) {
//                return true;
//            }
//        }
//
//        // no connecting road found
//        return false;
//    }
//
//    /**
//     * Returns the starting location of a road.
//     *
//     * @param road the road to get the starting location for
//     * @return the starting location of the road
//     */
//    private Location roadStart(Road road) {
//        return locations.get(0);
//    }
//
//    /**
//     * Returns the ending location of a road.
//     *
//     * @param road the road to get the ending location for
//     * @return the ending location of the road
//     */
//    private Location roadEnd(Road road) {
//        return locations.get(1);
//    }
//}
