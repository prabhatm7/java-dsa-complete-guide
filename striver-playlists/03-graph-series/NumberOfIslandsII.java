/*
 * Problem: Number of Islands II — process add-land queries, return count after each.
 *
 * Intuition: DSU on grid cells; on each addition, union with 4 neighbors already land.
 * Time: O(Q*alpha)  Space: O(n*m)
 */
import java.util.*;
public class NumberOfIslandsII {
    int[] par, rk;
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        par = new int[n * m]; rk = new int[n * m];
        for (int i = 0; i < n * m; i++) par[i] = -1;
        int cnt = 0;
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            int r = p[0], c = p[1], id = r * m + c;
            if (par[id] != -1) { res.add(cnt); continue; }
            par[id] = id; cnt++;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr<0||nr>=n||nc<0||nc>=m) continue;
                int nid = nr * m + nc;
                if (par[nid] != -1 && find(id) != find(nid)) { union(id, nid); cnt--; }
            }
            res.add(cnt);
        }
        return res;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (rk[ra] < rk[rb]) par[ra] = rb;
        else if (rk[ra] > rk[rb]) par[rb] = ra;
        else { par[rb] = ra; rk[ra]++; }
    }
}
