/*
 * Problem: Maximal Rectangle in binary matrix.
 *
 * Intuition: Per row build histogram of consecutive 1s; apply largest rectangle in histogram.
 * Time: O(n*m)  Space: O(m)
 */
import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] mat) {
        if (mat.length == 0) return 0;
        int m = mat[0].length, best = 0;
        int[] h = new int[m];
        for (char[] row : mat) {
            for (int j = 0; j < m; j++) h[j] = row[j] == '1' ? h[j] + 1 : 0;
            best = Math.max(best, lr(h));
        }
        return best;
    }
    private int lr(int[] h) {
        int n = h.length, best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? 0 : h[i];
            while (!st.isEmpty() && h[st.peek()] > cur) {
                int t = st.pop();
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                best = Math.max(best, h[t] * w);
            }
            st.push(i);
        }
        return best;
    }
}
