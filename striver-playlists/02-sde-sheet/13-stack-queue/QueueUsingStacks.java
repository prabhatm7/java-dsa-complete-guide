/*
 * Problem: Implement Queue using Stacks (amortized O(1)).
 *
 * Intuition: Two stacks — input for push, output for pop; move only when output empty.
 * Time: amortized O(1)  Space: O(n)
 */
import java.util.*;
public class QueueUsingStacks {
    Deque<Integer> in = new ArrayDeque<>(), out = new ArrayDeque<>();
    public void push(int x) { in.push(x); }
    public int pop() { peek(); return out.pop(); }
    public int peek() {
        if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop());
        return out.peek();
    }
    public boolean empty() { return in.isEmpty() && out.isEmpty(); }
}
