/*
 * Problem: Flatten Binary Tree to Linked List (preorder).
 *
 * Intuition: Reverse postorder (right, left, root); maintain prev pointer; rewrite right to prev, left to null.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class FlattenBTToLL {
    TreeNode prev = null;
    public void flatten(TreeNode r) {
        if (r == null) return;
        flatten(r.right);
        flatten(r.left);
        r.right = prev;
        r.left = null;
        prev = r;
    }
}
