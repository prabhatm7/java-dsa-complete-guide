/*
 * Problem: First Negative number in every window of size K.
 *
 * Intuition: Deque of indices of negatives within window; front = first negative.
 * Time: O(n)  Space: O(k)
 */
import java.util.*;
public class FirstNegativeInWindow {
    public List<Integer> firstNeg(int[] a, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) dq.offerLast(i);
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            if (i >= k - 1) res.add(dq.isEmpty() ? 0 : a[dq.peekFirst()]);
        }
        return res;
    }
}
