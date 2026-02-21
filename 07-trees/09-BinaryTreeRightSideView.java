// LC 199. Binary Tree Right Side View
// Approach: BFS level order, take last element of each level
// Time: O(n) | Space: O(n)
import java.util.*;

class BinaryTreeRightSideView {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
