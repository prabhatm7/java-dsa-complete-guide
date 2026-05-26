/*
 * Problem: Maximum of Minimums for every window size.
 *
 * Intuition: Using prev/next smaller arrays — element a[i] is min for windows of size (next-prev-1); take max.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class MaxOfMinsEveryWindow {
    public int[] maxOfMin(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n], res = new int[n + 1];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], a[i]);
        }
        for (int i = n - 1; i >= 1; i--) res[i] = Math.max(res[i], res[i + 1]);
        int[] out = new int[n];
        for (int i = 1; i <= n; i++) out[i - 1] = res[i];
        return out;
    }
}
