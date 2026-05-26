// LC 572. Subtree of Another Tree
// Approach: For each node in root, check if it's same tree as subRoot
// Time: O(m * n) | Space: O(h)
class SubtreeOfAnotherTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}

// Status : Accepted
// Revision Status : Required