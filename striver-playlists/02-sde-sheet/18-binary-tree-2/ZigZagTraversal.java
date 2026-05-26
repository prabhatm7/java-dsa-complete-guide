/*
 * Problem: Binary Tree Zig-Zag Level Order Traversal.
 *
 * Intuition: BFS; flip insertion order each level using a flag.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>(); q.offer(root);
        boolean l2r = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> lvl = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                if (l2r) lvl.addLast(n.val); else lvl.addFirst(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            res.add(lvl);
            l2r = !l2r;
        }
        return res;
    }
}
