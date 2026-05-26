/*
 * Problem: Search in BST.
 *
 * Intuition: Iterate; go left if target<val else right.
 * Time: O(h)  Space: O(1)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class SearchInBST {
    public TreeNode searchBST(TreeNode r, int v) {
        while (r != null && r.val != v) r = v < r.val ? r.left : r.right;
        return r;
    }
}
