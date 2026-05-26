// LC 226. Invert Binary Tree
// Approach: Recursively swap left and right children
// Time: O(n) | Space: O(h)
class InvertBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}

// what are we returing here matters

// Status : Accepted
// Revision Status : Required
