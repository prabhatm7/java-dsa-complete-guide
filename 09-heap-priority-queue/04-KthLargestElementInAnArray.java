// LC 215. Kth Largest Element in an Array
// Approach: Min-heap of size k OR Quickselect
// Heap: Time O(n log k) | Quickselect: Time O(n) avg
import java.util.*;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
