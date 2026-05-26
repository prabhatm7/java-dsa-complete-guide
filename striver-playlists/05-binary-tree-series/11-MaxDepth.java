/*
 * Problem: Max Depth of Binary Tree.
 *
 * Intuition: 1 + max(left depth, right depth).
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class MaxDepth {
    public int maxDepth(TreeNode r) { return r == null ? 0 : 1 + Math.max(maxDepth(r.left), maxDepth(r.right)); }
}
