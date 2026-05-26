/*
 * Problem: Rotate List by k places to the right.
 *
 * Intuition: Find length, make circular, then break at (len - k%len) from start.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1; ListNode t = head;
        while (t.next != null) { t = t.next; len++; }
        t.next = head;
        k = k % len;
        int steps = len - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
