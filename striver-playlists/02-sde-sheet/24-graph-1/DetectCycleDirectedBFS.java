/*
 * Problem: Detect Cycle in Directed Graph (Kahn's BFS).
 *
 * Intuition: Topological sort succeeds iff DAG; if processed nodes != V, cycle exists.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class DetectCycleDirectedBFS {
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        int[] in = new int[V];
        for (int u = 0; u < V; u++) for (int v : adj.get(u)) in[v]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (in[i] == 0) q.offer(i);
        int processed = 0;
        while (!q.isEmpty()) {
            int u = q.poll(); processed++;
            for (int v : adj.get(u)) if (--in[v] == 0) q.offer(v);
        }
        return processed != V;
    }
}
