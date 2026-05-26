/*
 * Problem: Middle of the Linked List (2nd middle if even).
 *
 * Intuition: Tortoise & hare; when fast reaches end, slow is at middle.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class MiddleOfList {
    public ListNode middleNode(ListNode head) {
        ListNode s = head, f = head;
        while (f != null && f.next != null) { s = s.next; f = f.next.next; }
        return s;
    }
}
