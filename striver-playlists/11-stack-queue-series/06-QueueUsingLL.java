/*
 * Problem: Queue using Linked List.
 *
 * Intuition: Maintain head and tail; enqueue appends to tail, dequeue removes head.
 * Time: O(1) per op  Space: O(n)
 */
class QNode { int val; QNode next; QNode(int v){val=v;} }
public class QueueUsingLL {
    QNode head, tail; int size;
    public void offer(int x) {
        QNode n = new QNode(x);
        if (head == null) head = tail = n;
        else { tail.next = n; tail = n; }
        size++;
    }
    public int poll() {
        int v = head.val; head = head.next; if (head == null) tail = null; size--; return v;
    }
}
