/*
 * Problem: All Root-to-Leaf Paths summing to target.
 *
 * Intuition: DFS with current path; at leaf if sum matches, record.
 * Time: O(n^2)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class AllPathSums {
    public List<List<Integer>> pathSum(TreeNode r, int t) {
        List<List<Integer>> res = new ArrayList<>();
        go(r, t, new ArrayList<>(), res);
        return res;
    }
    private void go(TreeNode n, int t, List<Integer> cur, List<List<Integer>> res) {
        if (n == null) return;
        cur.add(n.val);
        if (n.left == null && n.right == null && n.val == t) res.add(new ArrayList<>(cur));
        go(n.left, t - n.val, cur, res);
        go(n.right, t - n.val, cur, res);
        cur.remove(cur.size() - 1);
    }
}
