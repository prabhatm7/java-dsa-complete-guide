/*
 * Problem: Delete head, tail, by value, by position.
 *
 * Intuition: Re-link past the deleted node.
 * Time: O(n) worst  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class DeleteOperations {
    public ListNode deleteHead(ListNode h) { return h == null ? null : h.next; }
    public ListNode deleteTail(ListNode h) {
        if (h == null || h.next == null) return null;
        ListNode c = h; while (c.next.next != null) c = c.next;
        c.next = null;
        return h;
    }
    public ListNode deleteValue(ListNode h, int v) {
        if (h == null) return null;
        if (h.val == v) return h.next;
        ListNode c = h;
        while (c.next != null && c.next.val != v) c = c.next;
        if (c.next != null) c.next = c.next.next;
        return h;
    }
}
