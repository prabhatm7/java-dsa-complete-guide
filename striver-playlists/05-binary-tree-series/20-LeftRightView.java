/*
 * Problem: Left/Right View.
 *
 * Intuition: BFS taking first/last of each level; or DFS with depth, store first seen per depth.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class LeftRightView {
    public List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res, true);
        return res;
    }
    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res, false);
        return res;
    }
    private void dfs(TreeNode n, int d, List<Integer> res, boolean left) {
        if (n == null) return;
        if (d == res.size()) res.add(n.val);
        if (left) { dfs(n.left, d + 1, res, true); dfs(n.right, d + 1, res, true); }
        else { dfs(n.right, d + 1, res, false); dfs(n.left, d + 1, res, false); }
    }
}
