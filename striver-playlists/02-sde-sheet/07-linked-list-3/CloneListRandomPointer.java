/*
 * Problem: Copy List with Random Pointer
 *
 * Intuition: Insert cloned node after each original; assign random via orig.random.next; then split lists.
 * Time: O(n)  Space: O(1) extra
 */
class RNode { int val; RNode next, random; RNode(int v){val=v;} }
public class CloneListRandomPointer {
    public RNode copyRandomList(RNode head) {
        if (head == null) return null;
        RNode c = head;
        while (c != null) {
            RNode copy = new RNode(c.val);
            copy.next = c.next;
            c.next = copy;
            c = copy.next;
        }
        c = head;
        while (c != null) { if (c.random != null) c.next.random = c.random.next; c = c.next.next; }
        RNode dummy = new RNode(0), t = dummy; c = head;
        while (c != null) {
            t.next = c.next;
            t = t.next;
            c.next = c.next.next;
            c = c.next;
        }
        return dummy.next;
    }
}
