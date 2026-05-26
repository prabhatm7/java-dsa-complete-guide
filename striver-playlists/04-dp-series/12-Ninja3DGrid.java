/*
 * Problem: Ninjas — two friends in grid collecting chocolates; both start row 0 (col 0 and col m-1), reach row n-1.
 *
 * Intuition: 3D DP on (row, j1, j2); each takes 3 moves, total 9 transitions per cell; subtract if same column.
 * Time: O(n*m^2*9)  Space: O(m^2)
 */
public class Ninja3DGrid {
    public int chocolates(int n, int m, int[][] g) {
        int[][] prev = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) for (int j2 = 0; j2 < m; j2++)
            prev[j1][j2] = (j1 == j2) ? g[n-1][j1] : g[n-1][j1] + g[n-1][j2];
        for (int i = n - 2; i >= 0; i--) {
            int[][] cur = new int[m][m];
            for (int j1 = 0; j1 < m; j1++)
                for (int j2 = 0; j2 < m; j2++) {
                    int best = Integer.MIN_VALUE;
                    for (int d1 = -1; d1 <= 1; d1++)
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int nj1 = j1 + d1, nj2 = j2 + d2;
                            if (nj1 < 0 || nj1 >= m || nj2 < 0 || nj2 >= m) continue;
                            best = Math.max(best, prev[nj1][nj2]);
                        }
                    cur[j1][j2] = (j1 == j2 ? g[i][j1] : g[i][j1] + g[i][j2]) + best;
                }
            prev = cur;
        }
        return prev[0][m-1];
    }
}
