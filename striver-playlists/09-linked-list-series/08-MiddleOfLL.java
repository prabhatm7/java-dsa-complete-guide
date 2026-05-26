/*
 * Problem: Middle of Linked List.
 *
 * Intuition: Slow/fast pointers; slow is middle when fast reaches end.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class MiddleOfLL {
    public ListNode middle(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) { s = s.next; f = f.next.next; }
        return s;
    }
}
