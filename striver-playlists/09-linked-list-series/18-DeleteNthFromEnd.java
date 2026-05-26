/*
 * Problem: Delete Nth node from end.
 *
 * Intuition: Two pointers spaced n apart; when fast hits null, slow.next is target.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class DeleteNthFromEnd {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0, h), s = d, f = d;
        for (int i = 0; i < n; i++) f = f.next;
        while (f.next != null) { s = s.next; f = f.next; }
        s.next = s.next.next;
        return d.next;
    }
}
