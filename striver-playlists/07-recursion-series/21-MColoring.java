/*
 * Problem: M-Coloring — color graph with at most m colors so no adjacent share.
 *
 * Intuition: Backtrack; try colors 1..m if none used by neighbor.
 * Time: O(m^n)  Space: O(n)
 */
public class MColoring {
    public boolean graphColoring(int[][] g, int m, int n) {
        int[] col = new int[n];
        return go(0, g, m, n, col);
    }
    private boolean go(int u, int[][] g, int m, int n, int[] col) {
        if (u == n) return true;
        for (int c = 1; c <= m; c++) {
            if (ok(u, g, n, col, c)) {
                col[u] = c;
                if (go(u + 1, g, m, n, col)) return true;
                col[u] = 0;
            }
        }
        return false;
    }
    private boolean ok(int u, int[][] g, int n, int[] col, int c) {
        for (int k = 0; k < n; k++) if (k != u && g[u][k] == 1 && col[k] == c) return false;
        return true;
    }
}
