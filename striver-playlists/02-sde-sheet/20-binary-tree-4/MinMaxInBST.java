/*
 * Problem: Min / Max in BST.
 *
 * Intuition: Min = leftmost node; Max = rightmost node.
 * Time: O(h)  Space: O(1)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class MinMaxInBST {
    public int min(TreeNode r) { while (r.left != null) r = r.left; return r.val; }
    public int max(TreeNode r) { while (r.right != null) r = r.right; return r.val; }
}
