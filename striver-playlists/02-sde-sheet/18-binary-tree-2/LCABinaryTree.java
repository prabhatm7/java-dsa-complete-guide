/*
 * Problem: Lowest Common Ancestor in Binary Tree.
 *
 * Intuition: Recurse; if a node matches p or q, return it; if both subtrees return non-null, this node is LCA.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        if (r == null || r == p || r == q) return r;
        TreeNode l = lowestCommonAncestor(r.left, p, q);
        TreeNode rt = lowestCommonAncestor(r.right, p, q);
        if (l != null && rt != null) return r;
        return l != null ? l : rt;
    }
}
