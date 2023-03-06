package lab3.compulsory;

public interface Node extends Comparable<Node> {
    Nameable getNameable();

    @Override
    default int compareTo(Node other) {
        return this.getNameable().getName().compareTo(other.getNameable().getName());
    }
}