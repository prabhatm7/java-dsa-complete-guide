/*
 * Problem: Max Path Sum (any to any).
 *
 * Intuition: At each node candidate = val + max(0,l) + max(0,r); return val + max(0, max(l,r)) up.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class MaxPathSum {
    int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode r) { go(r); return best; }
    private int go(TreeNode n) {
        if (n == null) return 0;
        int l = Math.max(0, go(n.left)), r = Math.max(0, go(n.right));
        best = Math.max(best, n.val + l + r);
        return n.val + Math.max(l, r);
    }
}
