/*
 * Problem: Previous Smaller Element.
 *
 * Intuition: Monotonic stack scanning left-to-right.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class PreviousSmallerElement {
    public int[] prevSmaller(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= a[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(a[i]);
        }
        return res;
    }
}
