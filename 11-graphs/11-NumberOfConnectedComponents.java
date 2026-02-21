// LC 323. Number of Connected Components in an Undirected Graph
// Approach: Union-Find. Count distinct roots after processing all edges.
// Time: O(n * alpha(n)) | Space: O(n)
class NumberOfConnectedComponents {
    private int[] parent, rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) components--;
        }
        return components;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else { parent[py] = px; rank[px]++; }
        return true;
    }
}
