/*
 * Problem: Sliding Window Maximum.
 *
 * Intuition: Monotonic decreasing deque of indices; front always holds current window max; pop expired indices.
 * Time: O(n)  Space: O(k)
 */
import java.util.*;
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = a[dq.peekFirst()];
        }
        return res;
    }
}
