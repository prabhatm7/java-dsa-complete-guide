/*
 * Problem: Next Greater Element (circular array).
 *
 * Intuition: Monotonic decreasing stack; iterate 2n times for circularity.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = a[i % n];
            while (!st.isEmpty() && st.peek() <= x) st.pop();
            if (i < n && !st.isEmpty()) res[i] = st.peek();
            st.push(x);
        }
        return res;
    }
}
