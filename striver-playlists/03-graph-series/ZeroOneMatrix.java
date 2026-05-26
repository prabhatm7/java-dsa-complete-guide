/*
 * Problem: Distance of each cell from nearest 0 in binary matrix.
 *
 * Intuition: Multi-source BFS from all zeros simultaneously.
 * Time: O(n*m)  Space: O(n*m)
 */
import java.util.*;
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] d = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (mat[i][j] == 0) q.offer(new int[]{i, j});
            else d[i][j] = -1;
        }
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = c[0] + dr[k], nc = c[1] + dc[k];
                if (nr<0||nr>=n||nc<0||nc>=m||d[nr][nc]!=-1) continue;
                d[nr][nc] = d[c[0]][c[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return d;
    }
}
