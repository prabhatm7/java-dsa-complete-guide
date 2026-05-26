/*
 * Problem: Intersection of Two Linked Lists
 *
 * Intuition: Two pointers; when one reaches end, jump to other head; they meet at intersection after at most n+m steps.
 * Time: O(n+m)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class IntersectionOfLists {
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
