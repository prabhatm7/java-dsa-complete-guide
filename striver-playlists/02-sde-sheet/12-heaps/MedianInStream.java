/*
 * Problem: Find Median from Data Stream.
 *
 * Intuition: Two heaps — max-heap (lower half) and min-heap (upper half); balance sizes.
 * Time: O(log n) per add, O(1) median  Space: O(n)
 */
import java.util.*;
public class MedianInStream {
    PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<>();
    public void addNum(int x) {
        if (lo.isEmpty() || x <= lo.peek()) lo.offer(x); else hi.offer(x);
        if (lo.size() > hi.size() + 1) hi.offer(lo.poll());
        else if (hi.size() > lo.size()) lo.offer(hi.poll());
    }
    public double findMedian() {
        if (lo.size() == hi.size()) return (lo.peek() + hi.peek()) / 2.0;
        return lo.peek();
    }
}
