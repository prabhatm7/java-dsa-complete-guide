/*
 * Problem: Add Two Numbers (digits stored in reverse order in linked lists).
 *
 * Intuition: Walk both lists with a carry; create a node for each summed digit.
 * Time: O(max(n,m))  Space: O(max(n,m))
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), t = dummy;
        int c = 0;
        while (a != null || b != null || c != 0) {
            int s = c + (a != null ? a.val : 0) + (b != null ? b.val : 0);
            c = s / 10;
            t.next = new ListNode(s % 10);
            t = t.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        return dummy.next;
    }
}
