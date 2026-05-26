/*
 * Problem: Next Greater Element II — circular array.
 *
 * Intuition: Iterate twice, index modulo n.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= a[i % n]) st.pop();
            if (i < n && !st.isEmpty()) res[i] = st.peek();
            st.push(a[i % n]);
        }
        return res;
    }
}
