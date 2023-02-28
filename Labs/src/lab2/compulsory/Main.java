package lab2.compulsory;

import java.util.List;
import java.util.ArrayList;
public class Main {
    /**
     *
     * @param args can't be used to write in a shell
     *             maybe modify later tp write from keyboard
     */
    public static void main(String[] args) {
        Location location1 = new Location("Tokyo", LocationType.CITY, 10, -37);
        Location location2 = new Location("Seoul Int", LocationType.AIRPORT, 37, -59);
        Road road1 = new Road(RoadType.HIGHWAY, 3700, 200);
        Road road2 = new Road(RoadType.EXPRESSWAY, 370, 100);
        List<Road> roads = new ArrayList<>();
        roads.add(road1);
        roads.add(road2);
        Route route = new Route(location1, location2, roads);
        System.out.println(route.toString());
    }
}

//In the Road class, the toString() method returns a string that includes the type of road, length, and speed limit.
// In the Location class, the toString() method returns a string that includes the name, type, and coordinates of the location.
// In the Route class, the toString() method returns a string that includes the start and end locations and the list of roads that make up the route.
