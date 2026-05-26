/*
 * Problem: Insert at head, tail, given position.
 *
 * Intuition: Adjust pointers; for head replace head; for tail walk; for position walk to i-1.
 * Time: O(1) head, O(n) tail/position  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class InsertOperations {
    public ListNode insertHead(ListNode h, int v) { return new ListNode(v, h); }
    public ListNode insertTail(ListNode h, int v) {
        if (h == null) return new ListNode(v);
        ListNode c = h; while (c.next != null) c = c.next;
        c.next = new ListNode(v);
        return h;
    }
    public ListNode insertAt(ListNode h, int pos, int v) {
        if (pos == 0) return new ListNode(v, h);
        ListNode c = h;
        for (int i = 0; i < pos - 1 && c != null; i++) c = c.next;
        if (c == null) return h;
        c.next = new ListNode(v, c.next);
        return h;
    }
}
