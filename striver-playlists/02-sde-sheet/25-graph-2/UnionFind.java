/*
 * Problem: Union-Find (Disjoint Set Union) with union by rank + path compression.
 *
 * Intuition: Trees representing components; union joins smaller-rank under larger; find compresses path.
 * Time: ~O(alpha(n))  Space: O(n)
 */
public class UnionFind {
    int[] par, rk;
    public UnionFind(int n) {
        par = new int[n]; rk = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
    }
    public int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    public boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rk[ra] < rk[rb]) par[ra] = rb;
        else if (rk[ra] > rk[rb]) par[rb] = ra;
        else { par[rb] = ra; rk[ra]++; }
        return true;
    }
}
