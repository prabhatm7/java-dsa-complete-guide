/*
 * Problem: Clone Linked List with random pointer.
 *
 * Intuition: Interleave clones into original; set random; detach.
 * Time: O(n)  Space: O(1)
 */
class RNode { int val; RNode next, random; RNode(int v){val=v;} }
public class CloneRandomList {
    public RNode copyRandomList(RNode h) {
        if (h == null) return null;
        for (RNode c = h; c != null; c = c.next.next) {
            RNode cl = new RNode(c.val);
            cl.next = c.next;
            c.next = cl;
        }
        for (RNode c = h; c != null; c = c.next.next)
            c.next.random = c.random == null ? null : c.random.next;
        RNode head = h.next;
        for (RNode c = h; c != null; c = c.next) {
            RNode cl = c.next;
            c.next = cl.next;
            cl.next = cl.next == null ? null : cl.next.next;
        }
        return head;
    }
}
