// LC 124. Binary Tree Maximum Path Sum
// Approach: DFS. At each node, max gain = val + max(left, 0) + max(right, 0).
// Return val + max(one side, 0) to parent. Track global max.
// Time: O(n) | Space: O(h)
class BinaryTreeMaximumPathSum {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
