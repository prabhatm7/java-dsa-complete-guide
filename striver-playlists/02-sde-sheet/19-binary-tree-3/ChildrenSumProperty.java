/*
 * Problem: Convert tree so every node's value equals sum of its children (only increase values).
 *
 * Intuition: Top-down — if parent > childSum, push parent's value down; bottom-up — recompute sum.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class ChildrenSumProperty {
    public void convert(TreeNode r) {
        if (r == null) return;
        int c = 0;
        if (r.left != null) c += r.left.val;
        if (r.right != null) c += r.right.val;
        if (c >= r.val) r.val = c;
        else { if (r.left != null) r.left.val = r.val; if (r.right != null) r.right.val = r.val; }
        convert(r.left); convert(r.right);
        int tot = 0;
        if (r.left != null) tot += r.left.val;
        if (r.right != null) tot += r.right.val;
        if (r.left != null || r.right != null) r.val = tot;
    }
}
