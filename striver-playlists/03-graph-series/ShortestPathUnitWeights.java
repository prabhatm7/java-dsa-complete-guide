/*
 * Problem: Shortest path in undirected graph with unit weights.
 *
 * Intuition: Plain BFS layer count gives the distance.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class ShortestPathUnitWeights {
    public int[] shortestPath(int V, int src, List<List<Integer>> adj) {
        int[] d = new int[V];
        Arrays.fill(d, -1);
        d[src] = 0;
        Queue<Integer> q = new LinkedList<>(); q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) if (d[v] == -1) { d[v] = d[u] + 1; q.offer(v); }
        }
        return d;
    }
}
