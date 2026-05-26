/*
 * Problem: Maximum Width of Binary Tree.
 *
 * Intuition: BFS with positional index (2i, 2i+1); width per level = last - first + 1; normalize per level.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nq = new LinkedList<>();
        Queue<Integer> iq = new LinkedList<>();
        nq.offer(root); iq.offer(0);
        int best = 0;
        while (!nq.isEmpty()) {
            int sz = nq.size(), first = 0, last = 0, base = iq.peek();
            for (int i = 0; i < sz; i++) {
                TreeNode n = nq.poll(); int id = iq.poll() - base;
                if (i == 0) first = id;
                if (i == sz - 1) last = id;
                if (n.left != null) { nq.offer(n.left); iq.offer(2 * id); }
                if (n.right != null) { nq.offer(n.right); iq.offer(2 * id + 1); }
            }
            best = Math.max(best, last - first + 1);
        }
        return best;
    }
}
