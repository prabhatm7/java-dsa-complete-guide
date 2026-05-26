/*
 * Problem: Flatten Linked List (each node has next + bottom; bottom-sorted; result sorted via bottom).
 *
 * Intuition: Recurse rightward; merge current bottom-list with merged result of rest.
 * Time: O(N)  Space: O(N) recursion
 */
class FNode { int val; FNode next, bottom; FNode(int v){val=v;} }
public class FlattenLL {
    public FNode flatten(FNode h) {
        if (h == null || h.next == null) return h;
        return merge(h, flatten(h.next));
    }
    private FNode merge(FNode a, FNode b) {
        FNode d = new FNode(0), c = d;
        while (a != null && b != null) {
            if (a.val <= b.val) { c.bottom = a; a = a.bottom; }
            else { c.bottom = b; b = b.bottom; }
            c = c.bottom;
            c.next = null;
        }
        c.bottom = a != null ? a : b;
        return d.bottom;
    }
}
