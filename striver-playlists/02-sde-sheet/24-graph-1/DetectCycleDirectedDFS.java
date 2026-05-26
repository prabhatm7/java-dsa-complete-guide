/*
 * Problem: Detect Cycle in Directed Graph (DFS).
 *
 * Intuition: Use recursion stack; cycle exists if we revisit a node currently on the path.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class DetectCycleDirectedDFS {
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V], onPath = new boolean[V];
        for (int i = 0; i < V; i++) if (!vis[i] && dfs(i, adj, vis, onPath)) return true;
        return false;
    }
    private boolean dfs(int u, List<List<Integer>> adj, boolean[] vis, boolean[] onPath) {
        vis[u] = true; onPath[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v] && dfs(v, adj, vis, onPath)) return true;
            else if (onPath[v]) return true;
        }
        onPath[u] = false;
        return false;
    }
}
