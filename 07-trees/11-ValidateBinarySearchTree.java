// LC 98. Validate Binary Search Tree
// Approach: DFS with valid range (min, max). Each node must be within range.
// Time: O(n) | Space: O(h)
class ValidateBinarySearchTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
