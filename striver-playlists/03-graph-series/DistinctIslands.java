/*
 * Problem: Number of Distinct Islands (by shape).
 *
 * Intuition: DFS from each unvisited '1'; record path as relative coordinates from base; HashSet on signatures.
 * Time: O(n*m)  Space: O(n*m)
 */
import java.util.*;
public class DistinctIslands {
    public int countDistinctIslands(int[][] g) {
        int n = g.length, m = g[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<int[]>> shapes = new HashSet<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++)
            if (g[i][j] == 1 && !vis[i][j]) {
                List<int[]> shape = new ArrayList<>();
                dfs(g, i, j, i, j, vis, shape);
                shapes.add(new ArrayList<>(shape));
            }
        return shapes.size();
    }
    private void dfs(int[][] g, int r, int c, int br, int bc, boolean[][] vis, List<int[]> shape) {
        int n = g.length, m = g[0].length;
        if (r<0||r>=n||c<0||c>=m||vis[r][c]||g[r][c]==0) return;
        vis[r][c] = true;
        shape.add(new int[]{r - br, c - bc});
        dfs(g,r+1,c,br,bc,vis,shape); dfs(g,r-1,c,br,bc,vis,shape);
        dfs(g,r,c+1,br,bc,vis,shape); dfs(g,r,c-1,br,bc,vis,shape);
    }
}
