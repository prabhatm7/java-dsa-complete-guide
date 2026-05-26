/*
 * Problem: Add 1 to a number represented as LL (head is most significant).
 *
 * Intuition: Reverse, add 1 with carry, reverse back. Or recurse and add on return.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class AddOneToNumber {
    public ListNode addOne(ListNode h) {
        h = reverse(h);
        ListNode c = h; int carry = 1;
        while (c != null && carry != 0) {
            int s = c.val + carry;
            c.val = s % 10;
            carry = s / 10;
            if (carry != 0 && c.next == null) { c.next = new ListNode(carry); carry = 0; }
            c = c.next;
        }
        return reverse(h);
    }
    private ListNode reverse(ListNode h) {
        ListNode prev = null, cur = h;
        while (cur != null) { ListNode t = cur.next; cur.next = prev; prev = cur; cur = t; }
        return prev;
    }
}
