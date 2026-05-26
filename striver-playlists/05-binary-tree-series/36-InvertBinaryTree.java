/*
 * Problem: Invert Binary Tree.
 *
 * Intuition: Swap children; recurse.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode r) {
        if (r == null) return null;
        TreeNode t = r.left; r.left = invertTree(r.right); r.right = invertTree(t);
        return r;
    }
}
