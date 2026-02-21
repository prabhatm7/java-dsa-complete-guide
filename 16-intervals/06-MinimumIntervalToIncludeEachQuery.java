// LC 1851. Minimum Interval to Include Each Query
// Approach: Sort intervals by size. Sort queries. Use min-heap ordered by interval size.
// For each query (sorted), add all intervals whose start <= query, remove expired ones.
// Time: O(n log n + q log q) | Space: O(n + q)
import java.util.*;

class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) sortedQueries[i] = new int[]{queries[i], i};
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int j = 0;
        for (int[] q : sortedQueries) {
            while (j < intervals.length && intervals[j][0] <= q[0]) {
                pq.offer(new int[]{intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) pq.poll();
            if (!pq.isEmpty()) res[q[1]] = pq.peek()[0];
        }
        return res;
    }
}
