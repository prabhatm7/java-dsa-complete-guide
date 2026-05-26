/*
 * Problem: Intersection point of two linked lists.
 *
 * Intuition: Two pointers; when one finishes, redirect to other head; meet at intersection.
 * Time: O(n+m)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class IntersectionPoint {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        ListNode p = a, q = b;
        while (p != q) {
            p = p == null ? b : p.next;
            q = q == null ? a : q.next;
        }
        return p;
    }
}
