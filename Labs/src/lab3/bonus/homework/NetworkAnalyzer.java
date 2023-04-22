package lab3.bonus.homework;

import java.util.*;

public class NetworkAnalyzer {

    public List<Object> network;

    public NetworkAnalyzer(Network network) {
        this.network = Network.getNetwork();
    }


    public List<Object> findCutNodes() {
        Set<Object> visited = new HashSet<>();
        Queue<Object> queue = new LinkedList<>();
        List<Object> cutNodes = new ArrayList<>();

        // Step 1: Find if the network is connected
        Object startNode = network.get(0);
        visited.add(startNode);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Object node = queue.remove();
            for (Object neighbor : getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (visited.size() == network.size()) {
            // Network is connected, no cut nodes
            return cutNodes;
        }

        // Step 2: Find the cut nodes
        for (Object node : network) {
            network.remove(node);
            visited.clear();
            visited.add(startNode);
            queue.add(startNode);
            while (!queue.isEmpty()) {
                Object n = queue.remove();
                for (Object neighbor : getNeighbors(n)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            if (visited.size() < network.size()) {
                // Node is a cut node
                cutNodes.add(node);
            }
            network.add(node);
        }
        return cutNodes;
    }

    private List<Object> getNeighbors(Object node) {
        if (node instanceof Person) {
            return new ArrayList<>(network.stream()
                    .filter(n -> n instanceof Person && !n.equals(node))
                    .flatMap(p -> ((Person) p).getRelationships().keySet().stream())
                    .filter(p -> !p.equals(node))
                    .distinct()
                    .toList());
        } else if (node instanceof Company) {
            return new ArrayList<>(network.stream()
                    .filter(n -> n instanceof Person && ((Person) n).getEmployer().equals(node))
                    .map(p -> (Person) p)
                    .distinct()
                    .toList());
        } else {
            throw new IllegalArgumentException("Invalid node type");
        }
    }

    /**
     * Determines if there are nodes in the network which, if they are removed, disconnect the network.
     *
     * @return true if there are such nodes, false otherwise
     */
    public boolean hasDisconnectingNodes() {
        ArrayList<Object> nodes = new ArrayList<>(network);
        // Iterate through all nodes in the network
        for (Object node : nodes) {
            List<Object> neighbors = getNeighbors(node);
            for (Object neighbor : neighbors) {
                // Remove the current node and its neighbor from the network temporarily
                nodes.remove(node);
                if (node instanceof Person) {
                    ((Person) node).getRelationships().remove(neighbor);
                } else if (node instanceof Company) {
                    ((Company) node).getEmployees().remove(neighbor);
                }
                nodes.remove(neighbor);

                // Check if the network is still connected
                boolean isConnected = isConnected();

                // Add the nodes back to the network
                nodes.add(node);
                nodes.add(neighbor);
                if (node instanceof Person) {
                    ((Person) node).getRelationships().put((Person) neighbor, "coworker");
                } else if (node instanceof Company) {
                    ((Company) node).getEmployees().put((Person) neighbor, "employee");
                }

                // If the network is not connected, return true
                if (!isConnected) {
                    return true;
                }
            }
        }
        // If all nodes have been checked and the network is still connected, return false
        return false;
    }

    /**
     * Determines if the network is connected, i.e., if there is a path between every pair of nodes.
     *
     * @return true if the network is connected, false otherwise
     */
    private boolean isConnected() {
        ArrayList<Object> nodes = new ArrayList<>(network);
        Set<Object> visited = new HashSet<>();
        Queue<Object> queue = new LinkedList<>();

        // Start with an arbitrary node
        Object start = nodes.get(0);
        visited.add(start);
        queue.add(start);

        // Breadth-first search
        while (!queue.isEmpty()) {
            Object node = queue.remove();
            List<Object> neighbors = getNeighbors(node);
            for (Object neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // If there are unvisited nodes, the network is not connected
        return visited.size() == nodes.size();
    }
}
