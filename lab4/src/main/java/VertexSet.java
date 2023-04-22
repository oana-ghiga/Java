import java.util.*;

public class VertexSet<V> {

    private Set<V> vertices;

    public VertexSet() {
        vertices = new HashSet<>();
    }

    public VertexSet(Set<V> vertices) {
        this.vertices = new HashSet<>(vertices);
    }

    public boolean addVertex(V vertex) {
        return vertices.add(vertex);
    }

    public boolean removeVertex(V vertex) {
        return vertices.remove(vertex);
    }

    public boolean containsVertex(V vertex) {
        return vertices.contains(vertex);
    }

    public int size() {
        return vertices.size();
    }

    public Set<V> getVertices() {
        return new HashSet<>(vertices);
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}
