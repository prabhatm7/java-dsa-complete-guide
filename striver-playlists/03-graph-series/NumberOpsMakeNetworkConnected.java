/*
 * Problem: Minimum operations to make network connected (rewire cables).
 *
 * Intuition: With DSU, count components c and extra edges; need c-1 extras to merge.
 * Time: O(E*alpha)  Space: O(V)
 */
public class NumberOpsMakeNetworkConnected {
    int[] par, rk;
    public int makeConnected(int n, int[][] conn) {
        if (conn.length < n - 1) return -1;
        par = new int[n]; rk = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
        for (int[] c : conn) union(c[0], c[1]);
        int comp = 0;
        for (int i = 0; i < n; i++) if (find(i) == i) comp++;
        return comp - 1;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (rk[ra] < rk[rb]) par[ra] = rb;
        else if (rk[ra] > rk[rb]) par[rb] = ra;
        else { par[rb] = ra; rk[ra]++; }
    }
}
