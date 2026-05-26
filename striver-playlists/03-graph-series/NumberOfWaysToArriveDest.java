/*
 * Problem: Number of Ways to Arrive at Destination (shortest paths).
 *
 * Intuition: Dijkstra; ways[v] = ways[u] when d[u]+w == d[v]; ways[v] += ways[u] when equal new path.
 * Time: O((V+E) log V)  Space: O(V)
 */
import java.util.*;
public class NumberOfWaysToArriveDest {
    public int countPaths(int n, int[][] roads) {
        final int MOD = (int) 1e9 + 7;
        List<List<long[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] r : roads) {
            g.get(r[0]).add(new long[]{r[1], r[2]});
            g.get(r[1]).add(new long[]{r[0], r[2]});
        }
        long[] dist = new long[n], ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] c = pq.poll();
            long d = c[0]; int u = (int) c[1];
            if (d > dist[u]) continue;
            for (long[] e : g.get(u)) {
                int v = (int) e[0]; long w = e[1];
                if (d + w < dist[v]) { dist[v] = d + w; ways[v] = ways[u]; pq.offer(new long[]{dist[v], v}); }
                else if (d + w == dist[v]) ways[v] = (ways[v] + ways[u]) % MOD;
            }
        }
        return (int) ways[n - 1];
    }
}
