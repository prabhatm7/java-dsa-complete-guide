/*
 * Problem: Reverse a Doubly Linked List.
 *
 * Intuition: Walk, swap prev/next at each node; new head is the last node visited.
 * Time: O(n)  Space: O(1)
 */
class DListNode { int val; DListNode prev, next; DListNode(int v){val=v;} }
public class ReverseDLL {
    public DListNode reverse(DListNode h) {
        DListNode cur = h, last = null;
        while (cur != null) {
            last = cur;
            DListNode t = cur.next;
            cur.next = cur.prev;
            cur.prev = t;
            cur = t;
        }
        return last;
    }
}
