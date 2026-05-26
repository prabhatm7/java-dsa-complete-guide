/*
 * Problem: Merge K Sorted Arrays.
 *
 * Intuition: Min-heap of (value, arrayIdx, elemIdx); pop and push the next element of that array.
 * Time: O(N log k)  Space: O(k)
 */
import java.util.*;
public class MergeKSortedArrays {
    public List<Integer> merge(int[][] arrays) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arrays.length; i++) if (arrays[i].length > 0) pq.offer(new int[]{arrays[i][0], i, 0});
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            res.add(t[0]);
            if (t[2] + 1 < arrays[t[1]].length) pq.offer(new int[]{arrays[t[1]][t[2]+1], t[1], t[2]+1});
        }
        return res;
    }
}
