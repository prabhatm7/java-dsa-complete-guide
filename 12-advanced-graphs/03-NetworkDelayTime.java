// LC 743. Network Delay Time
// Approach: Dijkstra's algorithm from source node k. Return max distance (last node reached).
// Time: O(E log V) | Space: O(V + E)
import java.util.*;

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) graph.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (dist.containsKey(curr[0])) continue;
            dist.put(curr[0], curr[1]);
            if (graph.containsKey(curr[0]))
                for (int[] next : graph.get(curr[0]))
                    if (!dist.containsKey(next[0]))
                        pq.offer(new int[]{next[0], curr[1] + next[1]});
        }
        if (dist.size() != n) return -1;
        int max = 0;
        for (int d : dist.values()) max = Math.max(max, d);
        return max;
    }
}
