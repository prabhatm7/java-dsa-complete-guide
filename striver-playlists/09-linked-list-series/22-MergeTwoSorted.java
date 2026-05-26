/*
 * Problem: Merge Two Sorted Lists.
 *
 * Intuition: Dummy head; pick smaller front each step.
 * Time: O(n+m)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class MergeTwoSorted {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        while (a != null && b != null) {
            if (a.val <= b.val) { c.next = a; a = a.next; }
            else { c.next = b; b = b.next; }
            c = c.next;
        }
        c.next = a != null ? a : b;
        return d.next;
    }
}
