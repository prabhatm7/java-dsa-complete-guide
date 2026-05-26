/*
 * Problem: Minimum Spanning Tree using Kruskal's.
 *
 * Intuition: Sort edges by weight; iterate, add if endpoints in different DSU components.
 * Time: O(E log E)  Space: O(V)
 */
import java.util.*;
public class KruskalsMST {
    int[] par, rk;
    public int kruskal(int V, int[][] edges) {
        par = new int[V]; rk = new int[V];
        for (int i = 0; i < V; i++) par[i] = i;
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int sum = 0;
        for (int[] e : edges) if (union(e[0], e[1])) sum += e[2];
        return sum;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rk[ra] < rk[rb]) { par[ra] = rb; }
        else if (rk[ra] > rk[rb]) { par[rb] = ra; }
        else { par[rb] = ra; rk[ra]++; }
        return true;
    }
}
