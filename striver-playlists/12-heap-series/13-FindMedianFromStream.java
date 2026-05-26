/*
 * Problem: Find Median from Data Stream.
 *
 * Intuition: Two heaps — max-heap for lower half, min-heap for upper; balance sizes.
 * Time: O(log n) add, O(1) median  Space: O(n)
 */
import java.util.*;
public class FindMedianFromStream {
    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<>();
    public void addNum(int x) {
        lo.offer(x);
        hi.offer(lo.poll());
        if (hi.size() > lo.size()) lo.offer(hi.poll());
    }
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0;
    }
}
