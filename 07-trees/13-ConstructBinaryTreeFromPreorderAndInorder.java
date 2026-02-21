// LC 105. Construct Binary Tree from Preorder and Inorder Traversal
// Approach: Preorder first = root. Find root in inorder to split left/right subtrees.
// Use HashMap for O(1) inorder index lookup.
// Time: O(n) | Space: O(n)
import java.util.*;

class ConstructBinaryTreeFromPreorderAndInorder {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    private int preIdx = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int mid = inMap.get(root.val);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }
}
