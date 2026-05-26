/*
 * Problem: M-Coloring — can we color graph with at most m colors so no adjacent share color?
 *
 * Intuition: Backtracking — assign each node a color 1..m if not used by neighbor.
 * Time: O(m^n)  Space: O(n)
 */
public class MColoring {
    public boolean graphColoring(int[][] g, int m, int n) {
        int[] col = new int[n];
        return go(0, g, m, n, col);
    }
    private boolean go(int node, int[][] g, int m, int n, int[] col) {
        if (node == n) return true;
        for (int c = 1; c <= m; c++) {
            if (ok(node, g, n, col, c)) {
                col[node] = c;
                if (go(node + 1, g, m, n, col)) return true;
                col[node] = 0;
            }
        }
        return false;
    }
    private boolean ok(int node, int[][] g, int n, int[] col, int c) {
        for (int k = 0; k < n; k++) if (k != node && g[node][k] == 1 && col[k] == c) return false;
        return true;
    }
}
