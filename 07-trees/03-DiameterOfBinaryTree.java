// LC 543. Diameter of Binary Tree
// Approach: At each node, diameter through it = leftHeight + rightHeight. Track global max.
// Time: O(n) | Space: O(h)
class DiameterOfBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}


// Status : Accepted
// Revision Status : Required