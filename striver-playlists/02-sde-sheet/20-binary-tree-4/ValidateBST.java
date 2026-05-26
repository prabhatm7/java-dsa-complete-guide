/*
 * Problem: Validate Binary Search Tree.
 *
 * Intuition: Recurse with allowed (min, max) range bounds.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class ValidateBST {
    public boolean isValidBST(TreeNode r) { return go(r, Long.MIN_VALUE, Long.MAX_VALUE); }
    private boolean go(TreeNode n, long lo, long hi) {
        if (n == null) return true;
        if (n.val <= lo || n.val >= hi) return false;
        return go(n.left, lo, n.val) && go(n.right, n.val, hi);
    }
}
