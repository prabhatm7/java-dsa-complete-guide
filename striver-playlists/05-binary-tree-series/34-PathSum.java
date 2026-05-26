/*
 * Problem: Path Sum — does any root-to-leaf path sum to target?
 *
 * Intuition: Recurse; on leaf check remaining == val.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class PathSum {
    public boolean hasPathSum(TreeNode r, int t) {
        if (r == null) return false;
        if (r.left == null && r.right == null) return r.val == t;
        return hasPathSum(r.left, t - r.val) || hasPathSum(r.right, t - r.val);
    }
}
