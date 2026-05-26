/*
 * Problem: Min Stack — getMin in O(1).
 *
 * Intuition: Encode "smaller" elements as 2x - oldMin; on pop decode to recover oldMin.
 * Time: O(1)  Space: O(n)
 */
import java.util.*;
public class MinStack {
    Deque<Long> st = new ArrayDeque<>(); long min;
    public void push(int v) {
        if (st.isEmpty()) { st.push((long)v); min = v; }
        else if (v >= min) st.push((long)v);
        else { st.push(2L * v - min); min = v; }
    }
    public void pop() {
        long t = st.pop();
        if (t < min) min = 2 * min - t;
    }
    public int top() { long t = st.peek(); return (int)(t < min ? min : t); }
    public int getMin() { return (int) min; }
}
