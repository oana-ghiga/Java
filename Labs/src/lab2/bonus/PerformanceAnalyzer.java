package lab2.bonus;
import java.util.ArrayList;

public class PerformanceAnalyzer {
    public static void analyzeShortestRoute(Location from, Location to) {
        long startTime = System.nanoTime();
        Route shortestRoute = BestRoute.getShortestRoute(from, to);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Shortest route: " + shortestRoute);
        System.out.println("Time taken: " + duration + " nanoseconds");
    }

    public static void analyzeFastestRoute(Location from, Location to) {
        long startTime = System.nanoTime();
        Route fastestRoute = BestRoute.getFastestRoute(from, to);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Fastest route: " + fastestRoute);
        System.out.println("Time taken: " + duration + " nanoseconds");
    }

    public static void analyzePerformance(Location from, Location to) {
        analyzeShortestRoute(from, to);
        analyzeFastestRoute(from, to);
    }
}