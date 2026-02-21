// LC 1584. Min Cost to Connect All Points
// Approach: Prim's MST algorithm. Start from node 0, greedily add closest unvisited node.
// Time: O(n^2) | Space: O(n)
import java.util.*;

class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0, connected = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        while (connected < n) {
            int u = -1;
            for (int i = 0; i < n; i++)
                if (!visited[i] && (u == -1 || minDist[i] < minDist[u])) u = i;
            visited[u] = true;
            cost += minDist[u];
            connected++;
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }
        return cost;
    }
}
