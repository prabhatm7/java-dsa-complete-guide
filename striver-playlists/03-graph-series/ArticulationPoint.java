/*
 * Problem: Articulation Points.
 *
 * Intuition: DFS with tin & low; u is articulation if for some child v: low[v] >= tin[u] and u isn't root; root case: 2+ children.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class ArticulationPoint {
    int timer = 0;
    public List<Integer> articulationPoints(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n], mark = new boolean[n];
        int[] tin = new int[n], low = new int[n];
        for (int i = 0; i < n; i++) if (!vis[i]) dfs(i, -1, adj, vis, tin, low, mark);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (mark[i]) res.add(i);
        if (res.isEmpty()) res.add(-1);
        return res;
    }
    private void dfs(int u, int par, List<List<Integer>> g, boolean[] vis, int[] tin, int[] low, boolean[] mark) {
        vis[u] = true; tin[u] = low[u] = timer++;
        int children = 0;
        for (int v : g.get(u)) {
            if (v == par) continue;
            if (!vis[v]) {
                dfs(v, u, g, vis, tin, low, mark);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] >= tin[u] && par != -1) mark[u] = true;
                children++;
            } else low[u] = Math.min(low[u], tin[v]);
        }
        if (par == -1 && children > 1) mark[u] = true;
    }
}
