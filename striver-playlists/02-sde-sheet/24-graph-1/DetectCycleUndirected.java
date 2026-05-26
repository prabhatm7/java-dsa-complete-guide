/*
 * Problem: Detect Cycle in Undirected Graph (BFS).
 *
 * Intuition: For each component, BFS tracking parent; cycle if visited neighbor != parent.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class DetectCycleUndirected {
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) if (!vis[i] && bfs(i, adj, vis)) return true;
        return false;
    }
    private boolean bfs(int src, List<List<Integer>> adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, -1}); vis[src] = true;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int v : adj.get(c[0])) {
                if (!vis[v]) { vis[v] = true; q.offer(new int[]{v, c[0]}); }
                else if (v != c[1]) return true;
            }
        }
        return false;
    }
}
