/*
 * Problem: Queue using two stacks.
 *
 * Intuition: Push to in-stack; on pop/peek transfer to out-stack if empty.
 * Time: amortized O(1)  Space: O(n)
 */
import java.util.*;
public class QueueUsingStack {
    Deque<Integer> in = new ArrayDeque<>(), out = new ArrayDeque<>();
    public void push(int x) { in.push(x); }
    public int pop() { peek(); return out.pop(); }
    public int peek() {
        if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop());
        return out.peek();
    }
    public boolean isEmpty() { return in.isEmpty() && out.isEmpty(); }
}
