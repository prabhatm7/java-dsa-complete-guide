/*
 * Problem: Time to Burn a Tree from a node.
 *
 * Intuition: Parent map + BFS levels = time.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BurnTree {
    public int burn(TreeNode root, int target) {
        Map<TreeNode, TreeNode> par = new HashMap<>();
        TreeNode start = mark(root, target, par, null);
        Queue<TreeNode> q = new LinkedList<>(); q.offer(start);
        Set<TreeNode> vis = new HashSet<>(); vis.add(start);
        int time = -1;
        while (!q.isEmpty()) {
            int sz = q.size(); time++;
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                for (TreeNode nb : new TreeNode[]{n.left, n.right, par.get(n)})
                    if (nb != null && vis.add(nb)) q.offer(nb);
            }
        }
        return time;
    }
    private TreeNode mark(TreeNode n, int t, Map<TreeNode, TreeNode> p, TreeNode par) {
        if (n == null) return null;
        p.put(n, par);
        if (n.val == t) return n;
        TreeNode l = mark(n.left, t, p, n);
        return l != null ? l : mark(n.right, t, p, n);
    }
}
