// LC 230. Kth Smallest Element in a BST
// Approach: Inorder traversal (gives sorted order for BST). Return kth element.
// Time: O(h + k) | Space: O(h)
import java.util.*;

class KthSmallestElementInBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
