/*
 * Problem: Count nodes in a Complete Binary Tree.
 *
 * Intuition: If leftHeight == rightHeight: 2^h - 1; else recurse on subtrees.
 * Time: O(log^2 n)  Space: O(log n)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class CountNodesCompleteTree {
    public int countNodes(TreeNode r) {
        if (r == null) return 0;
        int l = lh(r), rh = rh(r);
        if (l == rh) return (1 << l) - 1;
        return 1 + countNodes(r.left) + countNodes(r.right);
    }
    private int lh(TreeNode n) { int c = 0; while (n != null) { c++; n = n.left; } return c; }
    private int rh(TreeNode n) { int c = 0; while (n != null) { c++; n = n.right; } return c; }
}
