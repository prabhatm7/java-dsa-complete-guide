/*
 * Problem: Start of Cycle in LL.
 *
 * Intuition: After meeting, reset one to head; advance both by 1; meeting point is cycle start.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class StartOfCycle {
    public ListNode detectCycle(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) {
                ListNode t = h;
                while (t != s) { t = t.next; s = s.next; }
                return t;
            }
        }
        return null;
    }
}
