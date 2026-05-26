// LC 100. Same Tree
// Approach: Recursively compare both trees - same val, same left, same right
// Time: O(n) | Space: O(h)
class SameTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Status : Accepted
// Revision Status : Required