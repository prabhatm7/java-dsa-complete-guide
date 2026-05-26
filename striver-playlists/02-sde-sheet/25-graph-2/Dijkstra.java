/*
 * Problem: Single Source Shortest Path with non-negative weights.
 *
 * Intuition: Priority queue of (dist, node); always extract min, relax outgoing edges.
 * Time: O((V+E) log V)  Space: O(V)
 */
import java.util.*;
public class Dijkstra {
    public int[] shortestPath(int V, int src, List<List<int[]>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int d = c[0], u = c[1];
            if (d > dist[u]) continue;
            for (int[] e : adj.get(u)) {
                int v = e[0], w = e[1];
                if (dist[u] + w < dist[v]) { dist[v] = dist[u] + w; pq.offer(new int[]{dist[v], v}); }
            }
        }
        return dist;
    }
}
