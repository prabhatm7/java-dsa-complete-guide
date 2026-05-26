/*
 * Problem: Diameter of Binary Tree.
 *
 * Intuition: While computing heights, candidate diameter at each node = left + right; track max.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class Diameter {
    int best = 0;
    public int diameter(TreeNode r) { h(r); return best; }
    private int h(TreeNode n) {
        if (n == null) return 0;
        int l = h(n.left), r = h(n.right);
        best = Math.max(best, l + r);
        return 1 + Math.max(l, r);
    }
}
