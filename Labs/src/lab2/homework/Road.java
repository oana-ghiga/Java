//package lab2.homework;
//
//public class Road {
//    private String type;
//    private double length;
//    private double speedLimit;
//    private Location start;
//    private Location end;
//
//    public Road(String type, double length, double speedLimit, Location start, Location end) {
//        this.type = type;
//        this.length = length;
//        this.speedLimit = speedLimit;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public double getLength() {
//        return length;
//    }
//
//    public double getSpeedLimit() {
//        return speedLimit;
//    }
//
//    public Location getStart() {
//        return start;
//    }
//
//    public Location getEnd() {
//        return end;
//    }
//
//    /**
//     * Compares this road with another object for equality.
//     * Two roads are equal if they have the same type, length, and speed limit.
//     *
//     * @param o the object to compare with
//     * @return true if this road is equal to the other object, false otherwise
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof Road)) {
//            return false;
//        }
//        Road other = (Road) o;
//        return this.type.equals(other.type) && this.length == other.length
//                && this.speedLimit == other.speedLimit;
//    }
//}