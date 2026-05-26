/*
 * Problem: Odd-Even Linked List (group odd-indexed first, even-indexed after).
 *
 * Intuition: Two chains; interleave; reconnect odd tail to even head.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class OddEvenLL {
    public ListNode oddEvenList(ListNode h) {
        if (h == null) return null;
        ListNode odd = h, even = h.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next; odd = odd.next;
            even.next = odd.next; even = even.next;
        }
        odd.next = evenHead;
        return h;
    }
}
