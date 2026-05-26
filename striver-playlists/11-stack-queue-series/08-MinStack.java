/*
 * Problem: Min Stack (O(1) getMin).
 *
 * Intuition: Encode (2x - min) when pushing if new minimum; decode on pop.
 * Time: O(1) per op  Space: O(n)
 */
import java.util.*;
public class MinStack {
    Deque<Long> st = new ArrayDeque<>();
    long min;
    public void push(int x) {
        if (st.isEmpty()) { st.push((long) x); min = x; }
        else if (x >= min) st.push((long) x);
        else { st.push(2L * x - min); min = x; }
    }
    public void pop() {
        long t = st.pop();
        if (t < min) min = 2 * min - t;
    }
    public int top() {
        long t = st.peek();
        return (int) (t < min ? min : t);
    }
    public int getMin() { return (int) min; }
}
