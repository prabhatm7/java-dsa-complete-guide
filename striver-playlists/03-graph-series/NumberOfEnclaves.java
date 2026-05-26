/*
 * Problem: Number of Enclaves — count land cells not reachable from boundary.
 *
 * Intuition: BFS/DFS from all boundary 1s to mark connected; remaining 1s are enclaves.
 * Time: O(n*m)  Space: O(n*m)
 */
import java.util.*;
public class NumberOfEnclaves {
    public int numEnclaves(int[][] g) {
        int n = g.length, m = g[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++)
            if ((i == 0 || j == 0 || i == n-1 || j == m-1) && g[i][j] == 1) { q.offer(new int[]{i,j}); g[i][j] = 0; }
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = c[0]+dr[k], nc = c[1]+dc[k];
                if (nr>=0&&nr<n&&nc>=0&&nc<m&&g[nr][nc]==1) { g[nr][nc]=0; q.offer(new int[]{nr,nc}); }
            }
        }
        int cnt = 0;
        for (int[] r : g) for (int v : r) cnt += v;
        return cnt;
    }
}
