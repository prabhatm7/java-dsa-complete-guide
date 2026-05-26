/*
 * Problem: N-Queens.
 *
 * Intuition: Column-by-column placement with row/diagonal trackers.
 * Time: O(n!)  Space: O(n)
 */
import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] b = new char[n][n];
        for (char[] r : b) Arrays.fill(r, '.');
        boolean[] row = new boolean[n], d1 = new boolean[2*n], d2 = new boolean[2*n];
        go(0, n, b, row, d1, d2, res);
        return res;
    }
    private void go(int c, int n, char[][] b, boolean[] row, boolean[] d1, boolean[] d2, List<List<String>> res) {
        if (c == n) {
            List<String> cur = new ArrayList<>();
            for (char[] r : b) cur.add(new String(r));
            res.add(cur);
            return;
        }
        for (int r = 0; r < n; r++) {
            if (row[r] || d1[r+c] || d2[r-c+n]) continue;
            b[r][c] = 'Q'; row[r] = d1[r+c] = d2[r-c+n] = true;
            go(c + 1, n, b, row, d1, d2, res);
            b[r][c] = '.'; row[r] = d1[r+c] = d2[r-c+n] = false;
        }
    }
}
