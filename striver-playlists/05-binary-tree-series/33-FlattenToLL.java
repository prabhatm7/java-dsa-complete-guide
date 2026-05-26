/*
 * Problem: Flatten Binary Tree to Linked List (preorder).
 *
 * Intuition: Reverse postorder (R,L,Root) with prev pointer; rewrite right=prev, left=null.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class FlattenToLL {
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
