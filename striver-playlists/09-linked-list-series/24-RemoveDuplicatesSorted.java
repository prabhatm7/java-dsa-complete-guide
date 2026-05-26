/*
 * Problem: Remove Duplicates from Sorted List.
 *
 * Intuition: Walk; skip cur.next when cur.next.val == cur.val.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class RemoveDuplicatesSorted {
    public ListNode deleteDuplicates(ListNode h) {
        ListNode c = h;
        while (c != null && c.next != null) {
            if (c.val == c.next.val) c.next = c.next.next;
            else c = c.next;
        }
        return h;
    }
}
