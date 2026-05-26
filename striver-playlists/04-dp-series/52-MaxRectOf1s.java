/*
 * Problem: Maximal Rectangle of 1s in binary matrix.
 *
 * Intuition: For each row, build histogram heights; apply largest rectangle in histogram on each.
 * Time: O(n*m)  Space: O(m)
 */
import java.util.*;
public class MaxRectOf1s {
    public int maximalRectangle(char[][] mat) {
        if (mat.length == 0) return 0;
        int m = mat[0].length, best = 0;
        int[] h = new int[m];
        for (char[] row : mat) {
            for (int j = 0; j < m; j++) h[j] = row[j] == '1' ? h[j] + 1 : 0;
            best = Math.max(best, largestRect(h));
        }
        return best;
    }
    private int largestRect(int[] h) {
        int n = h.length, best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? 0 : h[i];
            while (!st.isEmpty() && h[st.peek()] > cur) {
                int top = st.pop();
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                best = Math.max(best, h[top] * w);
            }
            st.push(i);
        }
        return best;
    }
}
