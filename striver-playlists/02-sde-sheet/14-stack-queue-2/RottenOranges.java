/*
 * Problem: Rotten Oranges — min minutes for all to rot (4-directional).
 *
 * Intuition: Multi-source BFS from all rotten cells; track time at each level.
 * Time: O(n*m)  Space: O(n*m)
 */
import java.util.*;
public class RottenOranges {
    public int orangesRotting(int[][] g) {
        int n = g.length, m = g[0].length, fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (g[i][j] == 2) q.offer(new int[]{i, j, 0});
            else if (g[i][j] == 1) fresh++;
        }
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}, time = {0};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            time[0] = c[2];
            for (int k = 0; k < 4; k++) {
                int nr = c[0] + dr[k], nc = c[1] + dc[k];
                if (nr<0||nr>=n||nc<0||nc>=m||g[nr][nc]!=1) continue;
                g[nr][nc] = 2; fresh--;
                q.offer(new int[]{nr, nc, c[2] + 1});
            }
        }
        return fresh == 0 ? time[0] : -1;
    }
}
