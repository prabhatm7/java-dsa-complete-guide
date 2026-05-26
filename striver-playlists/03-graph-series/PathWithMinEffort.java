/*
 * Problem: Path With Minimum Effort (max abs height diff along path is minimized).
 *
 * Intuition: Dijkstra-like — store min "effort" to reach a cell; relax neighbors with max instead of sum.
 * Time: O(n*m*log)  Space: O(n*m)
 */
import java.util.*;
public class PathWithMinEffort {
    public int minimumEffortPath(int[][] h) {
        int n = h.length, m = h[0].length;
        int[][] eff = new int[n][m];
        for (int[] r : eff) Arrays.fill(r, Integer.MAX_VALUE);
        eff[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (c[1] == n-1 && c[2] == m-1) return c[0];
            if (c[0] > eff[c[1]][c[2]]) continue;
            for (int k = 0; k < 4; k++) {
                int nr = c[1]+dr[k], nc = c[2]+dc[k];
                if (nr<0||nr>=n||nc<0||nc>=m) continue;
                int e = Math.max(c[0], Math.abs(h[nr][nc] - h[c[1]][c[2]]));
                if (e < eff[nr][nc]) { eff[nr][nc] = e; pq.offer(new int[]{e, nr, nc}); }
            }
        }
        return 0;
    }
}
