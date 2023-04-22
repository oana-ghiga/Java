import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class BipartiteGraph<V, P extends DefaultEdge> extends SimpleGraph<V, DefaultEdge> {

    private Set<V> partition1;
    private  Set<V> partition2;

    public BipartiteGraph(Class<? extends DefaultEdge> edgeClass) {
        super(edgeClass);
        partition1 = new HashSet<>();
        partition2 = new HashSet<>();
    }

    public boolean addVertexToPartition1(V vertex) {
        return partition1.add(vertex) && addVertex(vertex);
    }

    public boolean addVertexToPartition2(Project vertex) {
        return partition2.add((V) vertex) && addVertex((V) vertex);
    }

    public boolean addEdgeIfAdmissible(V vertex1, V vertex2, Set<V> admissibleVertices) {
        if (admissibleVertices.contains(vertex2)) {
            addEdge(vertex1, vertex2);
            return true;
        }
        return false;
    }

    public Set<V> getPartition1() {
        return partition1;
    }

    public Set<V> getPartition2() {
        return partition2;
    }

    public Set<V> getMinimumCardinalitySet() {
        if (partition1.size() < partition2.size()) {
            return partition1;
        }
        return partition2;
    }

    public Set<P> getMinimumCardinalitySetProject() {
        if (partition1.size() < partition2.size()) {
            return (Set<P>) partition1;
        }
        return (Set<P>) partition2;
    }

    public Set<V> getMaximumCardinalitySet() {
        if (partition1.size() > partition2.size()) {
            return partition1;
        }
        return partition2;
    }

    public Set<P> getMaximumCardinalitySetProject() {
        if (partition1.size() > partition2.size()) {
            return (Set<P>) partition1;
        }
        return (Set<P>) partition2;
    }

    public void addEdge(V student, P project) {
        super.addEdge(student, (V) project);
    }
}
