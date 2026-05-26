/*
 * Problem: Topological Sort of DAG (DFS-based).
 *
 * Intuition: DFS post-order; push to stack on return; reverse stack for order.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class TopologicalSort {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < V; i++) if (!vis[i]) dfs(i, adj, vis, st);
        int[] res = new int[V];
        int i = 0;
        while (!st.isEmpty()) res[i++] = st.pop();
        return res;
    }
    private void dfs(int u, List<List<Integer>> adj, boolean[] vis, Deque<Integer> st) {
        vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) dfs(v, adj, vis, st);
        st.push(u);
    }
}
