/*
 * Problem: Flatten a Linked List (each node has next + bottom; bottom lists are sorted; flatten into sorted bottom list).
 *
 * Intuition: Recurse to last; merge two sorted bottom lists pairwise from right to left.
 * Time: O(n*m)  Space: O(n) recursion
 */
class FNode { int val; FNode next, bottom; FNode(int v){val=v;} }
public class FlattenLinkedList {
    public FNode flatten(FNode root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        return mergeBottom(root, root.next);
    }
    private FNode mergeBottom(FNode a, FNode b) {
        FNode dummy = new FNode(0), t = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { t.bottom = a; a = a.bottom; }
            else { t.bottom = b; b = b.bottom; }
            t = t.bottom;
        }
        t.bottom = a != null ? a : b;
        return dummy.bottom;
    }
}
