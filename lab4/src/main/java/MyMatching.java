import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.matching.blossom.v5.*;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;

public class MyMatching {
    public static <V, E> Set<E> maximumCardinalityMatching(Graph<V, E> graph, Set<V> partition1) {
        HopcroftKarpMaximumCardinalityBipartiteMatching<V, E> matching = new HopcroftKarpMaximumCardinalityBipartiteMatching<>(graph, partition1, null);
        return (Set<E>) matching.getMatching();
    }
}
