package lab2.bonus;

public class Road {
    private RoadType roadType;
    private double length;
    private double speedLimit;
    private Location start;
    private Location end;

    public Road(RoadType roadType, Location start, Location end, double speedLimit) {
        this.roadType = roadType;
        this.start = start;
        this.end = end;
        this.length = start.distanceTo(end);
        this.speedLimit = speedLimit;
    }

    public RoadType getRoadType() {
        return roadType;
    }

    public double getLength() {
        return length;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public Location getFrom() {
        return start;
    }

    public Location getTo() {
        return end;
    }
}