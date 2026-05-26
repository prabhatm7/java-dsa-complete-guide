/*
 * Problem: BFS of a Graph from node 0.
 *
 * Intuition: Queue + visited array; pop and explore neighbors level by level.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
public class BFSTraversal {
    public List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); vis[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) if (!vis[v]) { vis[v] = true; q.offer(v); }
        }
        return res;
    }
}
