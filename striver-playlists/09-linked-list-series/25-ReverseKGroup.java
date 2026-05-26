/*
 * Problem: Reverse Linked List in K-groups.
 *
 * Intuition: For each k-block, reverse via standard reversal; chain.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode h, int k) {
        ListNode d = new ListNode(0, h), groupPrev = d;
        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break;
            ListNode groupNext = kth.next;
            ListNode prev = groupNext, cur = groupPrev.next;
            while (cur != groupNext) { ListNode t = cur.next; cur.next = prev; prev = cur; cur = t; }
            ListNode t = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = t;
        }
        return d.next;
    }
}
