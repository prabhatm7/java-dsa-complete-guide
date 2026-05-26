/*
 * Problem: Length of a Linked List.
 *
 * Intuition: Single pass counter.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class LengthOfLL {
    public int length(ListNode h) { int c = 0; while (h != null) { c++; h = h.next; } return c; }
}
