import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.matching.GreedyWeightedMatching;
import org.jgrapht.graph.DefaultEdge;

public class GreedyMatching<V> {

    public MatchingAlgorithm.Matching<V, DefaultEdge> findMaximumCardinalityMatching(Graph<V, DefaultEdge> graph) {
        GreedyWeightedMatching<V, DefaultEdge> matchingAlgorithm = new GreedyWeightedMatching<>(graph, false);
        return matchingAlgorithm.getMatching();
    }

}
