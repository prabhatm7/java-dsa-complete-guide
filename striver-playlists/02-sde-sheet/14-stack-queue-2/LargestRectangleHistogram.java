/*
 * Problem: Largest Rectangle in Histogram.
 *
 * Intuition: Monotonic increasing stack; on pop, height*width gives candidate area; width from prev smaller to next smaller.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] h) {
        int n = h.length, best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? 0 : h[i];
            while (!st.isEmpty() && h[st.peek()] > cur) {
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                best = Math.max(best, h[top] * width);
            }
            st.push(i);
        }
        return best;
    }
}
