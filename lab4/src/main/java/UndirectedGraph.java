import java.util.*;

public class UndirectedGraph<V, E> {
    private Map<V, Set<E>> vertices;
    private Set<E> edges;

    public UndirectedGraph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }

    public void addVertex(V v) {
        if (!vertices.containsKey(v)) {
            vertices.put(v, new HashSet<>());
        }
    }

    public void addEdge(V v1, V v2, E e) {
        addVertex(v1);
        addVertex(v2);
        vertices.get(v1).add(e);
        vertices.get(v2).add(e);
        edges.add(e);
    }

    public Set<V> getVertices() {
        return vertices.keySet();
    }

    public Set<E> getEdges() {
        return edges;
    }

    public Set<E> getEdges(V v) {
        return vertices.get(v);
    }

    public boolean containsEdge(V v1, V v2) {
        for (E e : vertices.get(v1)) {
            if (vertices.get(v2).contains(e)) {
                return true;
            }
        }
        return false;
    }
}
