/*
 * Problem: Max Depth of Binary Tree.
 *
 * Intuition: 1 + max(left, right) recursively.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class HeightOfTree {
    public int maxDepth(TreeNode r) {
        if (r == null) return 0;
        return 1 + Math.max(maxDepth(r.left), maxDepth(r.right));
    }
}
