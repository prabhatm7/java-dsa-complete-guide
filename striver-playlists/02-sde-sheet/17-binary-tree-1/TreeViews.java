/*
 * Problem: Left / Right / Top / Bottom View of Binary Tree.
 *
 * Intuition: Left/right via level order taking first/last per level; top/bottom via vertical column BFS with TreeMap.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class TreeViews {
    public List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>(); q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                if (i == 0) res.add(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }
        return res;
    }
    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>(); q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                if (i == sz - 1) res.add(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }
        return res;
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<int[]> q = new LinkedList<>();
        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root); q.offer(new int[]{0});
        while (!nq.isEmpty()) {
            TreeNode n = nq.poll(); int x = q.poll()[0];
            if (!m.containsKey(x)) m.put(x, n.val);
            if (n.left != null) { nq.offer(n.left); q.offer(new int[]{x - 1}); }
            if (n.right != null) { nq.offer(n.right); q.offer(new int[]{x + 1}); }
        }
        res.addAll(m.values());
        return res;
    }
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<int[]> q = new LinkedList<>();
        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root); q.offer(new int[]{0});
        while (!nq.isEmpty()) {
            TreeNode n = nq.poll(); int x = q.poll()[0];
            m.put(x, n.val);
            if (n.left != null) { nq.offer(n.left); q.offer(new int[]{x - 1}); }
            if (n.right != null) { nq.offer(n.right); q.offer(new int[]{x + 1}); }
        }
        res.addAll(m.values());
        return res;
    }
}
