// LC 102. Binary Tree Level Order Traversal
// Approach: BFS with queue. Process level by level using queue size.
// Time: O(n) | Space: O(n)
import java.util.*;

class BinaryTreeLevelOrderTraversal {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}

// Status : Accepted
// Revision Status : Required