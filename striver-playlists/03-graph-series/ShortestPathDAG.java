/*
 * Problem: Shortest Path in a Directed Acyclic Graph.
 *
 * Intuition: Topo sort; relax edges in topo order.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class ShortestPathDAG {
    public int[] shortestPath(int V, int src, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(new int[]{e[1], e[2]});
        boolean[] vis = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < V; i++) if (!vis[i]) topo(i, g, vis, st);
        int[] d = new int[V]; Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            if (d[u] == Integer.MAX_VALUE) continue;
            for (int[] e : g.get(u)) if (d[u] + e[1] < d[e[0]]) d[e[0]] = d[u] + e[1];
        }
        return d;
    }
    private void topo(int u, List<List<int[]>> g, boolean[] vis, Deque<Integer> st) {
        vis[u] = true;
        for (int[] e : g.get(u)) if (!vis[e[0]]) topo(e[0], g, vis, st);
        st.push(u);
    }
}
