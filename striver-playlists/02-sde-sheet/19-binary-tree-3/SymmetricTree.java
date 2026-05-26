/*
 * Problem: Symmetric Tree — mirror of itself.
 *
 * Intuition: Recurse with two pointers moving in mirror directions; values equal, left vs right matched.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class SymmetricTree {
    public boolean isSymmetric(TreeNode r) { return r == null || mirror(r.left, r.right); }
    private boolean mirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && mirror(a.left, b.right) && mirror(a.right, b.left);
    }
}
