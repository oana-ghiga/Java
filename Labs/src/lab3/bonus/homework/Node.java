package lab3.bonus.homework;

import lab3.compulsory.Nameable;

import java.util.Collection;
import java.util.List;

public interface Node extends Comparable<lab3.compulsory.Node> {
    Nameable getNameable();

    @Override
    default int compareTo(lab3.compulsory.Node other) {
        return this.getNameable().getName().compareTo(other.getNameable().getName());
    }

    List<Node> getNeighbors();


}