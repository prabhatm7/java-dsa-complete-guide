/*
 * Problem: K Closest Points to Origin.
 *
 * Intuition: Max-heap by squared distance of size k.
 * Time: O(n log k)  Space: O(k)
 */
import java.util.*;
public class KClosestToOrigin {
    public int[][] kClosest(int[][] pts, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for (int[] p : pts) { pq.offer(p); if (pq.size() > k) pq.poll(); }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }
}
