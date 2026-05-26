/*
 * Problem: Stack using a single queue.
 *
 * Intuition: On push, enqueue then rotate so new element is at front.
 * Time: O(n) push, O(1) others  Space: O(n)
 */
import java.util.*;
public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) q.offer(q.poll());
    }
    public int pop() { return q.poll(); }
    public int top() { return q.peek(); }
    public boolean isEmpty() { return q.isEmpty(); }
}
