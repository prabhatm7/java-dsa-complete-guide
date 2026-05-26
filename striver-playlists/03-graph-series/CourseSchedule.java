/*
 * Problem: Course Schedule I — can all courses be finished?
 *
 * Intuition: Topo sort via Kahn's; if all nodes consumed, no cycle => feasible.
 * Time: O(V+E)  Space: O(V+E)
 */
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] in = new int[n];
        for (int[] p : pre) { g.get(p[1]).add(p[0]); in[p[0]]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (in[i] == 0) q.offer(i);
        int done = 0;
        while (!q.isEmpty()) {
            int u = q.poll(); done++;
            for (int v : g.get(u)) if (--in[v] == 0) q.offer(v);
        }
        return done == n;
    }
}
