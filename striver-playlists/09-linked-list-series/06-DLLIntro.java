/*
 * Problem: Doubly Linked List intro and operations.
 *
 * Intuition: Node has prev and next; insertions/deletions update both directions.
 * Time: O(n) for traversal  Space: O(1)
 */
class DListNode { int val; DListNode prev, next; DListNode(int v){val=v;} }
public class DLLIntro {
    public DListNode insertHead(DListNode h, int v) {
        DListNode n = new DListNode(v);
        n.next = h;
        if (h != null) h.prev = n;
        return n;
    }
    public DListNode deleteNode(DListNode h, DListNode del) {
        if (del.prev != null) del.prev.next = del.next; else h = del.next;
        if (del.next != null) del.next.prev = del.prev;
        return h;
    }
}
