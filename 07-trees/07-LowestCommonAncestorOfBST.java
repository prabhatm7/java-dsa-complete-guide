// LC 235. Lowest Common Ancestor of a BST
// Approach: If both values < node, go left. If both > node, go right. Else current is LCA.
// Time: O(h) | Space: O(1)
class LowestCommonAncestorOfBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}
