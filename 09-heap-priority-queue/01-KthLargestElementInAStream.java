// LC 703. Kth Largest Element in a Stream
// Approach: Min-heap of size k. Top is always kth largest.
// Time: O(n log k) init, O(log k) add | Space: O(k)
import java.util.*;

class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}
