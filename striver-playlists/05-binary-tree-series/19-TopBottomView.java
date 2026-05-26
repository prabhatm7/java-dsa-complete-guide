/*
 * Problem: Top and Bottom Views.
 *
 * Intuition: BFS with column; top = first per col, bottom = last per col; TreeMap by col.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class TopBottomView {
    public List<Integer> topView(TreeNode root) { return view(root, true); }
    public List<Integer> bottomView(TreeNode root) { return view(root, false); }
    private List<Integer> view(TreeNode root, boolean top) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<TreeNode> nq = new LinkedList<>();
        Queue<int[]> cq = new LinkedList<>();
        nq.offer(root); cq.offer(new int[]{0});
        while (!nq.isEmpty()) {
            TreeNode n = nq.poll(); int c = cq.poll()[0];
            if (top) m.putIfAbsent(c, n.val); else m.put(c, n.val);
            if (n.left != null) { nq.offer(n.left); cq.offer(new int[]{c - 1}); }
            if (n.right != null) { nq.offer(n.right); cq.offer(new int[]{c + 1}); }
        }
        res.addAll(m.values());
        return res;
    }
}
