/*
 * Problem: Stack using Linked List.
 *
 * Intuition: Push prepends to head; pop returns head.
 * Time: O(1) per op  Space: O(n)
 */
class SNode { int val; SNode next; SNode(int v){val=v;} }
public class StackUsingLL {
    SNode head; int size;
    public void push(int x) { SNode n = new SNode(x); n.next = head; head = n; size++; }
    public int pop() { int v = head.val; head = head.next; size--; return v; }
    public int top() { return head.val; }
    public int size() { return size; }
}
