/*
 * Problem: Detect Cycle in Linked List.
 *
 * Intuition: Floyd's tortoise & hare; if they meet, cycle exists.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class DetectCycle {
    public boolean hasCycle(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) return true;
        }
        return false;
    }
}
