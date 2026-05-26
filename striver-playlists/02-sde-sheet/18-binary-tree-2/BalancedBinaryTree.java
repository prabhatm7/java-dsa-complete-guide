/*
 * Problem: Check if Binary Tree is Height-Balanced.
 *
 * Intuition: Compute height; return -1 if any subtree unbalanced; propagate failure.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode r) { return h(r) != -1; }
    private int h(TreeNode n) {
        if (n == null) return 0;
        int l = h(n.left); if (l == -1) return -1;
        int r = h(n.right); if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
