/*
 * Problem: Online Stock Span.
 *
 * Intuition: Stack of (price, span); pop while top<=current and accumulate span.
 * Time: O(1) amortized  Space: O(n)
 */
import java.util.*;
public class StockSpan {
    Deque<int[]> st = new ArrayDeque<>();
    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) span += st.pop()[1];
        st.push(new int[]{price, span});
        return span;
    }
}
