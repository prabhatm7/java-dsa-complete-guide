/*
 * Problem: Minimum Multiplications to Reach End (modular).
 *
 * Intuition: BFS — multiply current by each array entry mod 1e5; track first time reaching end.
 * Time: O(1e5 * n)  Space: O(1e5)
 */
import java.util.*;
public class MinMultiplicationsToReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        int MOD = 100000;
        int[] d = new int[MOD];
        Arrays.fill(d, -1);
        d[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == end) return d[u];
            for (int x : arr) {
                int v = (u * x) % MOD;
                if (d[v] == -1) { d[v] = d[u] + 1; q.offer(v); }
            }
        }
        return -1;
    }
}
