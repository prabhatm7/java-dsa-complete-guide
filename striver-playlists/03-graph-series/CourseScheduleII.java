/*
 * Problem: Course Schedule II — return any valid ordering.
 *
 * Intuition: Kahn's topo sort; collect popped order.
 * Time: O(V+E)  Space: O(V+E)
 */
import java.util.*;
public class CourseScheduleII {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] in = new int[n];
        for (int[] p : pre) { g.get(p[1]).add(p[0]); in[p[0]]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (in[i] == 0) q.offer(i);
        int[] res = new int[n]; int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            res[idx++] = u;
            for (int v : g.get(u)) if (--in[v] == 0) q.offer(v);
        }
        return idx == n ? res : new int[0];
    }
}
