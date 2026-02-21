// LC 295. Find Median from Data Stream
// Approach: Two heaps - maxHeap for lower half, minHeap for upper half.
// Balance so maxHeap.size >= minHeap.size and diff <= 1.
// Time: O(log n) add, O(1) findMedian | Space: O(n)
import java.util.*;

class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
