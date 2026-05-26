// LC 110. Balanced Binary Tree
// Approach: DFS returning height. Return -1 if unbalanced (height diff > 1).
// Time: O(n) | Space: O(h)
class BalancedBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}

// Status : Accepted
// Revision Status : Required