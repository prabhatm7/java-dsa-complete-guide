/*
 * Problem: Delete Middle Node.
 *
 * Intuition: Slow/fast; stop slow one before middle (using prev) and skip.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode h) {
        if (h == null || h.next == null) return null;
        ListNode s = h, f = h, prev = null;
        while (f != null && f.next != null) { prev = s; s = s.next; f = f.next.next; }
        prev.next = s.next;
        return h;
    }
}
