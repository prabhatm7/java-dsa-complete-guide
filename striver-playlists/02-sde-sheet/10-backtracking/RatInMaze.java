/*
 * Problem: Rat in a Maze — print all paths from (0,0) to (n-1,n-1) using DLRU.
 *
 * Intuition: DFS with visited; try directions in lex order D<L<R<U; backtrack.
 * Time: O(4^(n^2))  Space: O(n^2)
 */
import java.util.*;
public class RatInMaze {
    int[] dr = {1, 0, 0, -1}; int[] dc = {0, -1, 1, 0}; char[] dn = {'D','L','R','U'};
    public List<String> findPaths(int[][] m, int n) {
        List<String> res = new ArrayList<>();
        if (m[0][0] == 0) return res;
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        go(0, 0, n, m, vis, new StringBuilder(), res);
        return res;
    }
    private void go(int r, int c, int n, int[][] m, boolean[][] v, StringBuilder sb, List<String> res) {
        if (r == n-1 && c == n-1) { res.add(sb.toString()); return; }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k], nc = c + dc[k];
            if (nr>=0 && nr<n && nc>=0 && nc<n && !v[nr][nc] && m[nr][nc]==1) {
                v[nr][nc] = true; sb.append(dn[k]);
                go(nr, nc, n, m, v, sb, res);
                sb.deleteCharAt(sb.length()-1); v[nr][nc] = false;
            }
        }
    }
}
