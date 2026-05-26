/*
 * Problem: K Most Frequent Elements.
 *
 * Intuition: HashMap counts; min-heap of size k keyed on frequency.
 * Time: O(n log k)  Space: O(n)
 */
import java.util.*;
public class TopKFrequent {
    public int[] topKFrequent(int[] a, int k) {
        Map<Integer, Integer> c = new HashMap<>();
        for (int x : a) c.merge(x, 1, Integer::sum);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (Map.Entry<Integer, Integer> e : c.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll()[0];
        return res;
    }
}
