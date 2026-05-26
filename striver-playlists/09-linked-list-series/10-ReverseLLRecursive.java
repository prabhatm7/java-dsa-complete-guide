/*
 * Problem: Reverse Linked List (recursive).
 *
 * Intuition: Recurse to end; flip pointer on return.
 * Time: O(n)  Space: O(n)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class ReverseLLRecursive {
    public ListNode reverse(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode rest = reverse(h.next);
        h.next.next = h;
        h.next = null;
        return rest;
    }
}
