/*
 * Problem: Add Two Numbers represented as LL (digits reverse order).
 *
 * Intuition: Walk both with carry; build result.
 * Time: O(max(n,m))  Space: O(max(n,m))
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        int carry = 0;
        while (a != null || b != null || carry != 0) {
            int s = carry;
            if (a != null) { s += a.val; a = a.next; }
            if (b != null) { s += b.val; b = b.next; }
            c.next = new ListNode(s % 10);
            carry = s / 10;
            c = c.next;
        }
        return d.next;
    }
}
