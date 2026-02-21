// LC 332. Reconstruct Itinerary
// Approach: Hierholzer's algorithm for Eulerian path. DFS with greedy smallest lexical neighbor.
// Use PriorityQueue for each airport. Add to result in reverse (post-order).
// Time: O(E log E) | Space: O(E)
import java.util.*;

class ReconstructItinerary {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets)
            graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> neighbors = graph.get(airport);
        while (neighbors != null && !neighbors.isEmpty())
            dfs(neighbors.poll());
        result.addFirst(airport);
    }
}
