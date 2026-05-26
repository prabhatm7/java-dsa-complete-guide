/*
 * Problem: Find Eventual Safe States.
 *
 * Intuition: Reverse edges; nodes with no outgoing (originally) are safe; toposort reverse graph.
 * Time: O(V+E)  Space: O(V+E)
 */
import java.util.*;
public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
        int[] in = new int[n];
        for (int u = 0; u < n; u++) for (int v : g[u]) { rev.get(v).add(u); in[u]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (in[i] == 0) q.offer(i);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll(); res.add(u);
            for (int v : rev.get(u)) if (--in[v] == 0) q.offer(v);
        }
        Collections.sort(res);
        return res;
    }
}
