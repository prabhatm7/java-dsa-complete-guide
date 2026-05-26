/*
 * Problem: Number of Islands (4-directional).
 *
 * Intuition: Scan grid; on '1', DFS to mark connected land cells and increment count.
 * Time: O(n*m)  Space: O(n*m)
 */
public class NumberOfIslands {
    public int numIslands(char[][] g) {
        int n = g.length, m = g[0].length, cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] == '1') { cnt++; dfs(g, i, j, n, m); }
        return cnt;
    }
    private void dfs(char[][] g, int r, int c, int n, int m) {
        if (r<0||r>=n||c<0||c>=m||g[r][c]!='1') return;
        g[r][c] = '0';
        dfs(g,r+1,c,n,m); dfs(g,r-1,c,n,m); dfs(g,r,c+1,n,m); dfs(g,r,c-1,n,m);
    }
}
