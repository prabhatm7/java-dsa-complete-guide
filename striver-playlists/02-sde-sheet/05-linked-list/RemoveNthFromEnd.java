/*
 * Problem: Remove Nth Node From End of List
 *
 * Intuition: Two pointers; advance fast by n+1, then move both until fast is null; slow is at node before target.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), s = dummy, f = dummy;
        for (int i = 0; i <= n; i++) f = f.next;
        while (f != null) { s = s.next; f = f.next; }
        s.next = s.next.next;
        return dummy.next;
    }
}
