/*
 * Problem: Starting Point of Cycle in Linked List
 *
 * Intuition: Tortoise & hare meet inside cycle; reset slow to head; both move 1 step — they meet at cycle start.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class CycleStartPoint {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) {
                s = head;
                while (s != f) { s = s.next; f = f.next; }
                return s;
            }
        }
        return null;
    }
}
