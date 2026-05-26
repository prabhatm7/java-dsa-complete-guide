/*
 * Problem: Rotten Oranges — minutes until all oranges rot (multi-source BFS).
 *
 * Intuition: Enqueue all rotten initially; BFS layers count minutes; final fresh > 0 means -1.
 * Time: O(n*m)  Space: O(n*m)
 */
import java.util.*;
public class RottenOranges {
    public int orangesRotting(int[][] g) {
        int n = g.length, m = g[0].length, fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (g[i][j] == 2) q.offer(new int[]{i, j, 0});
            else if (g[i][j] == 1) fresh++;
        }
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        int time = 0;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            time = c[2];
            for (int k = 0; k < 4; k++) {
                int nr = c[0]+dr[k], nc = c[1]+dc[k];
                if (nr>=0 && nr<n && nc>=0 && nc<m && g[nr][nc]==1) {
                    g[nr][nc] = 2; fresh--;
                    q.offer(new int[]{nr, nc, c[2]+1});
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}
