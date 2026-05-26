/*
 * Problem: Diameter of Binary Tree (longest path between any two nodes).
 *
 * Intuition: For each node, candidate diameter = leftHeight + rightHeight; track global max while computing heights.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class DiameterOfTree {
    int best = 0;
    public int diameterOfBinaryTree(TreeNode r) { h(r); return best; }
    private int h(TreeNode n) {
        if (n == null) return 0;
        int l = h(n.left), r = h(n.right);
        best = Math.max(best, l + r);
        return 1 + Math.max(l, r);
    }
}
