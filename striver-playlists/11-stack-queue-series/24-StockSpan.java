/*
 * Problem: Stock Span Problem (online).
 *
 * Intuition: Monotonic decreasing stack of (price, span); on new price absorb spans of smaller-or-equal previous.
 * Time: amortized O(1)  Space: O(n)
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
