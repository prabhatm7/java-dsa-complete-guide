/*
 * Problem: Kth Largest Element in an Array.
 *
 * Intuition: Min-heap of size k; final top is kth largest.
 * Time: O(n log k)  Space: O(k)
 */
import java.util.*;
public class KthLargestElement {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a) {
            pq.offer(x);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
