/*
 * Problem: Next Smaller Element.
 *
 * Intuition: Monotonic stack of increasing values from the right.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class NextSmallerElement {
    public int[] nextSmaller(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= a[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(a[i]);
        }
        return res;
    }
}
