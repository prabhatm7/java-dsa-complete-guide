/*
 * Problem: Bellman-Ford — single-source shortest path with negative weights / negative cycle detection.
 *
 * Intuition: Relax all edges V-1 times; one more relaxation possible => negative cycle.
 * Time: O(V*E)  Space: O(V)
 */
import java.util.*;
public class BellmanFord {
    public int[] bellmanFord(int V, int src, int[][] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]])
                    dist[e[1]] = dist[e[0]] + e[2];
            }
        }
        for (int[] e : edges)
            if (dist[e[0]] != Integer.MAX_VALUE && dist[e[0]] + e[2] < dist[e[1]])
                return new int[]{-1};
        return dist;
    }
}
