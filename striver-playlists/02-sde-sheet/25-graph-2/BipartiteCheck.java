/*
 * Problem: Check if Graph is Bipartite (2-color).
 *
 * Intuition: BFS color nodes alternately; conflict => not bipartite.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class BipartiteCheck {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] col = new int[V]; Arrays.fill(col, -1);
        for (int i = 0; i < V; i++) {
            if (col[i] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i); col[i] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (col[v] == -1) { col[v] = 1 - col[u]; q.offer(v); }
                    else if (col[v] == col[u]) return false;
                }
            }
        }
        return true;
    }
}
