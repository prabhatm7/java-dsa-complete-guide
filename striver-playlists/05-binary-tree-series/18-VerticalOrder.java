/*
 * Problem: Vertical Order Traversal.
 *
 * Intuition: BFS with (col,row); TreeMap<col, TreeMap<row, PQ>>; sort by col, then row, then value.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class VerticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0});
        while (!q.isEmpty()) {
            Object[] t = q.poll();
            TreeNode n = (TreeNode) t[0]; int c = (int) t[1], r = (int) t[2];
            m.computeIfAbsent(c, x -> new TreeMap<>()).computeIfAbsent(r, x -> new PriorityQueue<>()).offer(n.val);
            if (n.left != null) q.offer(new Object[]{n.left, c - 1, r + 1});
            if (n.right != null) q.offer(new Object[]{n.right, c + 1, r + 1});
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> col : m.values()) {
            List<Integer> cur = new ArrayList<>();
            for (PriorityQueue<Integer> pq : col.values()) while (!pq.isEmpty()) cur.add(pq.poll());
            res.add(cur);
        }
        return res;
    }
}
