/*
 * Problem: Implement Stack using Queues (single queue).
 *
 * Intuition: On push, rotate queue so new element ends up at front.
 * Time: push O(n), others O(1)  Space: O(n)
 */
import java.util.*;
public class StackUsingQueues {
    Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) q.offer(q.poll());
    }
    public int pop() { return q.poll(); }
    public int top() { return q.peek(); }
    public boolean empty() { return q.isEmpty(); }
}
