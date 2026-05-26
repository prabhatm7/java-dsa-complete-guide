/*
 * Problem: Reverse Linked List (iterative).
 *
 * Intuition: Walk maintaining prev; flip each next pointer.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class ReverseLLIterative {
    public ListNode reverse(ListNode h) {
        ListNode prev = null, cur = h;
        while (cur != null) { ListNode t = cur.next; cur.next = prev; prev = cur; cur = t; }
        return prev;
    }
}
