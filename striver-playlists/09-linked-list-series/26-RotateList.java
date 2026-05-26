/*
 * Problem: Rotate Linked List by k positions.
 *
 * Intuition: Find length; make circular; break at (n - k%n).
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class RotateList {
    public ListNode rotateRight(ListNode h, int k) {
        if (h == null || h.next == null || k == 0) return h;
        int n = 1; ListNode t = h;
        while (t.next != null) { t = t.next; n++; }
        t.next = h;
        k = k % n;
        ListNode newTail = h;
        for (int i = 0; i < n - k - 1; i++) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
