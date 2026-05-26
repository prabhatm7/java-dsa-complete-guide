/*
 * Problem: Flood Fill — change connected region with same color to newColor.
 *
 * Intuition: DFS from start; recolor matching cells if not already newColor.
 * Time: O(n*m)  Space: O(n*m)
 */
public class FloodFill {
    public int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
        int orig = img[sr][sc];
        if (orig != newColor) dfs(img, sr, sc, orig, newColor);
        return img;
    }
    private void dfs(int[][] g, int r, int c, int orig, int nc) {
        if (r<0||r>=g.length||c<0||c>=g[0].length||g[r][c]!=orig) return;
        g[r][c] = nc;
        dfs(g,r+1,c,orig,nc); dfs(g,r-1,c,orig,nc); dfs(g,r,c+1,orig,nc); dfs(g,r,c-1,orig,nc);
    }
}
