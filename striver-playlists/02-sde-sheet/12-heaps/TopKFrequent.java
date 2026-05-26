/*
 * Problem: K Most Frequent Elements.
 *
 * Intuition: Count frequencies; min-heap of size k by frequency.
 * Time: O(n log k)  Space: O(n)
 */
import java.util.*;
public class TopKFrequent {
    public int[] topKFrequent(int[] a, int k) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int x : a) f.merge(x, 1, Integer::sum);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll()[0];
        return res;
    }
}
