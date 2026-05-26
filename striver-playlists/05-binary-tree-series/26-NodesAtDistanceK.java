/*
 * Problem: All Nodes at Distance K from Target.
 *
 * Intuition: BFS with parent map.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class NodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par = new HashMap<>();
        addPar(root, null, par);
        Queue<TreeNode> q = new LinkedList<>(); q.offer(target);
        Set<TreeNode> vis = new HashSet<>(); vis.add(target);
        int d = 0;
        while (!q.isEmpty()) {
            if (d == k) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode n : q) res.add(n.val);
                return res;
            }
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                for (TreeNode nb : new TreeNode[]{n.left, n.right, par.get(n)})
                    if (nb != null && vis.add(nb)) q.offer(nb);
            }
            d++;
        }
        return new ArrayList<>();
    }
    private void addPar(TreeNode n, TreeNode p, Map<TreeNode, TreeNode> map) {
        if (n == null) return;
        map.put(n, p);
        addPar(n.left, n, map); addPar(n.right, n, map);
    }
}
