package lab2.homework;

public class Main {

    public static void main(String[] args) {
        // create a problem instance
        BestRouteProblem problem = new BestRouteProblem();

        // add some locations
        Location city1 = new City("New York City", "city" ,40.7128, -74.0060, 8_336_817,0);
        Location city2 = new City("Los Angeles", "city", 34.0522, -118.2437, 3_971_883, 0);
        Location airport1 = new Airport("JFK Airport", "airport", 40.6413, -73.7781, 4);
        Location gasStation1 = new GasStation("Exxon", "airport" , 40.7340, -74.0029, 2.99);

        problem.addLocation(city1);
        problem.addLocation(city2);
        problem.addLocation(airport1);
        problem.addLocation(gasStation1);

        // add some roads
        Road highway1 = new Highway("I-95", 10, 70, city1, airport1);
        Road express1 = new Express("Garden State Parkway", 5, 60, city1, gasStation1);
        Road country1 = new Country("County Road 519", 7, 50, airport1, city2);

        problem.addRoad(highway1);
        problem.addRoad(express1);
        problem.addRoad(country1);

        // test if a route is possible
        Location start = city1;
        Location end = airport1;
        boolean routePossible = problem.isRoutePossible(start, end);
        System.out.println("Is a route possible from " + start.getName() + " to " + end.getName() + "? " + routePossible);
    }

}
//just what kind of a massive headache was this ffs