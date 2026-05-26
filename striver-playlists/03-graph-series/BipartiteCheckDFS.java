/*
 * Problem: Bipartite Check via DFS.
 *
 * Intuition: 2-color DFS; flip color for child; conflict => not bipartite.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class BipartiteCheckDFS {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] col = new int[V]; Arrays.fill(col, -1);
        for (int i = 0; i < V; i++)
            if (col[i] == -1 && !dfs(i, 0, adj, col)) return false;
        return true;
    }
    private boolean dfs(int u, int c, List<List<Integer>> adj, int[] col) {
        col[u] = c;
        for (int v : adj.get(u)) {
            if (col[v] == -1) { if (!dfs(v, 1 - c, adj, col)) return false; }
            else if (col[v] == c) return false;
        }
        return true;
    }
}
