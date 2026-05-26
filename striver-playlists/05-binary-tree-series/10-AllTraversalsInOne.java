/*
 * Problem: All Three Traversals (pre/in/post) in One Stack Pass.
 *
 * Intuition: Stack of (node, state 1/2/3); 1 -> pre+push left; 2 -> in+push right; 3 -> post.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class AllTraversalsInOne {
    public List<List<Integer>> all(TreeNode root) {
        List<Integer> pre = new ArrayList<>(), in = new ArrayList<>(), post = new ArrayList<>();
        if (root == null) return Arrays.asList(pre, in, post);
        Deque<int[]> sIdx = new ArrayDeque<>();
        Deque<TreeNode> sNode = new ArrayDeque<>();
        sNode.push(root); sIdx.push(new int[]{1});
        while (!sNode.isEmpty()) {
            int s = sIdx.peek()[0];
            TreeNode n = sNode.peek();
            if (s == 1) { pre.add(n.val); sIdx.peek()[0] = 2; if (n.left != null) { sNode.push(n.left); sIdx.push(new int[]{1}); } }
            else if (s == 2) { in.add(n.val); sIdx.peek()[0] = 3; if (n.right != null) { sNode.push(n.right); sIdx.push(new int[]{1}); } }
            else { post.add(n.val); sNode.pop(); sIdx.pop(); }
        }
        return Arrays.asList(pre, in, post);
    }
}
