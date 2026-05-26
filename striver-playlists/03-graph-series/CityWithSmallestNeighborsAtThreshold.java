/*
 * Problem: Find City With Smallest Number of Neighbors at Threshold Distance.
 *
 * Intuition: Floyd-Warshall all-pairs; for each city count reachable within threshold; pick min count, tiebreak max index.
 * Time: O(V^3)  Space: O(V^2)
 */
public class CityWithSmallestNeighborsAtThreshold {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] d = new int[n][n];
        int INF = 100_000_000;
        for (int i = 0; i < n; i++) { java.util.Arrays.fill(d[i], INF); d[i][i] = 0; }
        for (int[] e : edges) { d[e[0]][e[1]] = e[2]; d[e[1]][e[0]] = e[2]; }
        for (int k = 0; k < n; k++) for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
        int best = -1, minCnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) if (i != j && d[i][j] <= t) c++;
            if (c <= minCnt) { minCnt = c; best = i; }
        }
        return best;
    }
}
