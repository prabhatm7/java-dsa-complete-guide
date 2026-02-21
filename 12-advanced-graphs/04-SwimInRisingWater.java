// LC 778. Swim in Rising Water
// Approach: Binary search on time + BFS, or Dijkstra's (min-heap on max elevation in path).
// Time: O(n^2 log n) | Space: O(n^2)
import java.util.*;

class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[2];
            if (curr[0] == n - 1 && curr[1] == n - 1) return time;
            for (int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.offer(new int[]{ni, nj, Math.max(time, grid[ni][nj])});
                }
            }
        }
        return -1;
    }
}
