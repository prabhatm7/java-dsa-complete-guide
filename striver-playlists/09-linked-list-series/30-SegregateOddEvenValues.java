/*
 * Problem: Segregate Even and Odd values (evens first).
 *
 * Intuition: Two dummy lists, even and odd; iterate appending; join.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class SegregateOddEvenValues {
    public ListNode segregate(ListNode h) {
        ListNode dE = new ListNode(0), dO = new ListNode(0);
        ListNode tE = dE, tO = dO;
        while (h != null) {
            if ((h.val & 1) == 0) { tE.next = h; tE = tE.next; }
            else { tO.next = h; tO = tO.next; }
            h = h.next;
        }
        tE.next = dO.next; tO.next = null;
        return dE.next;
    }
}
