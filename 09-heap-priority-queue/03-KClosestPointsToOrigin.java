// LC 973. K Closest Points to Origin
// Approach: Max-heap of size k based on distance. Keep only k closest.
// Time: O(n log k) | Space: O(k)
import java.util.*;

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.toArray(new int[k][]);
    }
}
