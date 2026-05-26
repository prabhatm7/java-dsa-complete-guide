/*
 * Problem: Celebrity Problem — celebrity knows nobody but is known by all.
 *
 * Intuition: Stack: push all; pop two; if a knows b -> a not celeb (push b); else b not celeb (push a); verify last.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class CelebrityProblem {
    public int celebrity(int[][] m) {
        int n = m.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) st.push(i);
        while (st.size() > 1) {
            int a = st.pop(), b = st.pop();
            if (m[a][b] == 1) st.push(b); else st.push(a);
        }
        int c = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != c && (m[c][i] == 1 || m[i][c] == 0)) return -1;
        }
        return c;
    }
}
