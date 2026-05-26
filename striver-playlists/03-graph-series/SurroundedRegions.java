/*
 * Problem: Surrounded Regions — flip 'O' regions not connected to border to 'X'.
 *
 * Intuition: DFS from border 'O's marking with sentinel; then flip remaining 'O' to 'X' and sentinel back to 'O'.
 * Time: O(n*m)  Space: O(n*m)
 */
public class SurroundedRegions {
    public void solve(char[][] b) {
        int n = b.length, m = b[0].length;
        for (int i = 0; i < n; i++) { if (b[i][0]=='O') dfs(b,i,0); if (b[i][m-1]=='O') dfs(b,i,m-1); }
        for (int j = 0; j < m; j++) { if (b[0][j]=='O') dfs(b,0,j); if (b[n-1][j]=='O') dfs(b,n-1,j); }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) b[i][j] = b[i][j] == '#' ? 'O' : 'X';
    }
    private void dfs(char[][] b, int r, int c) {
        if (r<0||r>=b.length||c<0||c>=b[0].length||b[r][c]!='O') return;
        b[r][c] = '#';
        dfs(b,r+1,c); dfs(b,r-1,c); dfs(b,r,c+1); dfs(b,r,c-1);
    }
}
