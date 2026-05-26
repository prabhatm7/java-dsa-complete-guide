/*
 * Problem: Root to Node Path in Binary Tree.
 *
 * Intuition: DFS pushing nodes; on match return true; pop on backtrack.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class RootToNodePath {
    public List<Integer> path(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        go(root, target, res);
        return res;
    }
    private boolean go(TreeNode n, int t, List<Integer> res) {
        if (n == null) return false;
        res.add(n.val);
        if (n.val == t) return true;
        if (go(n.left, t, res) || go(n.right, t, res)) return true;
        res.remove(res.size() - 1);
        return false;
    }
}
