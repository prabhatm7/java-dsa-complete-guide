/*
 * Problem: DFS of a Graph from node 0.
 *
 * Intuition: Recurse on unvisited neighbors with visited array.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class DFSTraversal {
    public List<Integer> dfs(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        go(0, adj, vis, res);
        return res;
    }
    private void go(int u, List<List<Integer>> adj, boolean[] vis, List<Integer> res) {
        vis[u] = true; res.add(u);
        for (int v : adj.get(u)) if (!vis[v]) go(v, adj, vis, res);
    }
}
