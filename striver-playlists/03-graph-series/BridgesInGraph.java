/*
 * Problem: Bridges in Graph (Tarjan's Algorithm).
 *
 * Intuition: DFS with discovery time tin & low-link; edge (u,v) is a bridge if low[v] > tin[u].
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class BridgesInGraph {
    int timer = 0;
    List<List<Integer>> bridges = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conn) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (List<Integer> e : conn) { g.get(e.get(0)).add(e.get(1)); g.get(e.get(1)).add(e.get(0)); }
        int[] tin = new int[n], low = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) if (!vis[i]) dfs(i, -1, g, vis, tin, low);
        return bridges;
    }
    private void dfs(int u, int par, List<List<Integer>> g, boolean[] vis, int[] tin, int[] low) {
        vis[u] = true; tin[u] = low[u] = timer++;
        for (int v : g.get(u)) {
            if (v == par) continue;
            if (!vis[v]) {
                dfs(v, u, g, vis, tin, low);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > tin[u]) bridges.add(Arrays.asList(u, v));
            } else low[u] = Math.min(low[u], tin[v]);
        }
    }
}
