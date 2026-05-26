/*
 * Problem: Floyd-Warshall — all pairs shortest paths.
 *
 * Intuition: For each intermediate k, dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]).
 * Time: O(V^3)  Space: O(V^2)
 */
public class FloydWarshall {
    public void floydWarshall(int[][] d) {
        int n = d.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE)
                        if (d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
    }
}
