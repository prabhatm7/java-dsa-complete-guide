/*
 * Problem: Merge K Sorted Arrays.
 *
 * Intuition: Min-heap of (value, arrayIdx, elementIdx); always take smallest and push next from that array.
 * Time: O(N log k)  Space: O(k)
 */
import java.util.*;
public class MergeKSortedArrays {
    public List<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) if (arr[i].length > 0) pq.offer(new int[]{arr[i][0], i, 0});
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            res.add(t[0]);
            if (t[2] + 1 < arr[t[1]].length) pq.offer(new int[]{arr[t[1]][t[2]+1], t[1], t[2]+1});
        }
        return res;
    }
}
