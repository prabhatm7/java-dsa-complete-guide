/*
 * Problem: Number of Provinces (connected components in undirected graph from matrix).
 *
 * Intuition: DFS from each unvisited node; count starts.
 * Time: O(V^2)  Space: O(V)
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] m) {
        int n = m.length, cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) if (!vis[i]) { cnt++; dfs(i, m, vis); }
        return cnt;
    }
    private void dfs(int u, int[][] m, boolean[] vis) {
        vis[u] = true;
        for (int v = 0; v < m.length; v++) if (m[u][v] == 1 && !vis[v]) dfs(v, m, vis);
    }
}
