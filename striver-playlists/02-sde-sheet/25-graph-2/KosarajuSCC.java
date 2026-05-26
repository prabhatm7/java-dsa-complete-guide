/*
 * Problem: Strongly Connected Components (Kosaraju).
 *
 * Intuition: 1) DFS push finish-order; 2) transpose graph; 3) DFS in reverse finish order — each DFS = one SCC.
 * Time: O(V+E)  Space: O(V+E)
 */
import java.util.*;
public class KosarajuSCC {
    public int countSCC(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < V; i++) if (!vis[i]) order(i, adj, vis, st);
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());
        for (int u = 0; u < V; u++) for (int v : adj.get(u)) rev.get(v).add(u);
        Arrays.fill(vis, false);
        int scc = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!vis[u]) { scc++; dfs(u, rev, vis); }
        }
        return scc;
    }
    private void order(int u, List<List<Integer>> adj, boolean[] vis, Deque<Integer> st) {
        vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) order(v, adj, vis, st);
        st.push(u);
    }
    private void dfs(int u, List<List<Integer>> adj, boolean[] vis) {
        vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) dfs(v, adj, vis);
    }
}
