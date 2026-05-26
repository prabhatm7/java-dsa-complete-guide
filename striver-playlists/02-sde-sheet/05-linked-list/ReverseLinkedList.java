/*
 * Problem: Reverse a Linked List
 *
 * Intuition: Iteratively flip pointers using prev/curr/next; or recurse and re-wire.
 * Time: O(n)  Space: O(1) iterative / O(n) recursive
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
