/*
 * Problem: Sort linked list of 0s, 1s, and 2s.
 *
 * Intuition: Three dummy lists; append by value; join.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class Sort012LL {
    public ListNode sortList(ListNode h) {
        ListNode d0 = new ListNode(0), d1 = new ListNode(0), d2 = new ListNode(0);
        ListNode t0 = d0, t1 = d1, t2 = d2;
        while (h != null) {
            if (h.val == 0) { t0.next = h; t0 = t0.next; }
            else if (h.val == 1) { t1.next = h; t1 = t1.next; }
            else { t2.next = h; t2 = t2.next; }
            h = h.next;
        }
        t0.next = d1.next != null ? d1.next : d2.next;
        t1.next = d2.next;
        t2.next = null;
        return d0.next;
    }
}
