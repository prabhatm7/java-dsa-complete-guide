// LC 104. Maximum Depth of Binary Tree
// Approach: Recursion - depth = 1 + max(left depth, right depth)
// Time: O(n) | Space: O(h)
class MaximumDepthOfBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
