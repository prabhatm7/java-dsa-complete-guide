/*
 * Problem: Symmetric Tree.
 *
 * Intuition: Mirror recursion.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class Symmetric {
    public boolean isSymmetric(TreeNode r) { return r == null || m(r.left, r.right); }
    private boolean m(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && m(a.left, b.right) && m(a.right, b.left);
    }
}
