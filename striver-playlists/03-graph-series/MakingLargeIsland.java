/*
 * Problem: Making a Large Island — flip at most one 0 to 1; return largest island.
 *
 * Intuition: DSU/DFS to label islands & sizes; for each 0, sum unique neighbor island sizes + 1.
 * Time: O(n^2)  Space: O(n^2)
 */
import java.util.*;
public class MakingLargeIsland {
    int[] par, sz;
    public int largestIsland(int[][] g) {
        int n = g.length;
        par = new int[n*n]; sz = new int[n*n];
        for (int i = 0; i < n*n; i++) { par[i] = i; sz[i] = 1; }
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            if (g[i][j] == 1) for (int k = 0; k < 4; k++) {
                int nr = i+dr[k], nc = j+dc[k];
                if (nr>=0&&nr<n&&nc>=0&&nc<n&&g[nr][nc]==1) union(i*n+j, nr*n+nc);
            }
        int best = 0;
        for (int i = 0; i < n*n; i++) if (find(i) == i) best = Math.max(best, sz[i]);
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
            if (g[i][j] != 0) continue;
            Set<Integer> roots = new HashSet<>();
            for (int k = 0; k < 4; k++) {
                int nr = i+dr[k], nc = j+dc[k];
                if (nr>=0&&nr<n&&nc>=0&&nc<n&&g[nr][nc]==1) roots.add(find(nr*n+nc));
            }
            int total = 1;
            for (int r : roots) total += sz[r];
            best = Math.max(best, total);
        }
        return best;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (sz[ra] < sz[rb]) { par[ra] = rb; sz[rb] += sz[ra]; }
        else { par[rb] = ra; sz[ra] += sz[rb]; }
    }
}
