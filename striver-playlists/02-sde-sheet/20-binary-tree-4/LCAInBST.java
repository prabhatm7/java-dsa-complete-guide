/*
 * Problem: LCA in BST.
 *
 * Intuition: First node where p and q split (one on each side, or equals current).
 * Time: O(h)  Space: O(1)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        while (r != null) {
            if (p.val < r.val && q.val < r.val) r = r.left;
            else if (p.val > r.val && q.val > r.val) r = r.right;
            else return r;
        }
        return null;
    }
}
