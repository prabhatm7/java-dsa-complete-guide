// LC 1448. Count Good Nodes in Binary Tree
// Approach: DFS tracking max value from root to current node. Good if val >= max.
// Time: O(n) | Space: O(h)
class CountGoodNodesInBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int count = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        return count + dfs(node.left, max) + dfs(node.right, max);
    }
}
