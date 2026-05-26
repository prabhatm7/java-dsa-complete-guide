/*
 * Problem: Cheapest Flights Within K Stops.
 *
 * Intuition: BFS with state (node, stops); relax only when fewer stops or cheaper price.
 * Time: O(E*K)  Space: O(V)
 */
import java.util.*;
public class CheapestFlightsKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] f : flights) g.get(f[0]).add(new int[]{f[1], f[2]});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int u = c[0], cost = c[1], stops = c[2];
            if (stops > k) continue;
            for (int[] e : g.get(u)) {
                int nc = cost + e[1];
                if (nc < dist[e[0]]) { dist[e[0]] = nc; q.offer(new int[]{e[0], nc, stops + 1}); }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
