/*
 * Problem: Graph Representation (adjacency matrix vs list).
 *
 * Intuition: Matrix O(V^2) space, O(1) edge check; List O(V+E) space, faster neighbor iteration.
 * Time: build O(E)  Space: O(V+E)
 */
import java.util.*;
public class GraphRepresentation {
    public List<List<Integer>> buildAdjList(int V, int[][] edges, boolean directed) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            if (!directed) adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
}
