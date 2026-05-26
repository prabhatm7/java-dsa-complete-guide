/*
 * Problem: Sort Linked List (merge sort).
 *
 * Intuition: Split at middle; recursively sort halves; merge.
 * Time: O(n log n)  Space: O(log n)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class SortLL {
    public ListNode sortList(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode s = h, f = h.next;
        while (f != null && f.next != null) { s = s.next; f = f.next.next; }
        ListNode r = s.next; s.next = null;
        return merge(sortList(h), sortList(r));
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        while (a != null && b != null) {
            if (a.val <= b.val) { c.next = a; a = a.next; }
            else { c.next = b; b = b.next; }
            c = c.next;
        }
        c.next = a != null ? a : b;
        return d.next;
    }
}
