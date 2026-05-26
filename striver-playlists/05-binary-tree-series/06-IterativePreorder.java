/*
 * Problem: Iterative Preorder.
 *
 * Intuition: Stack — push root; pop, visit, push right then left.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class IterativePreorder {
    public List<Integer> preorder(TreeNode r) {
        List<Integer> res = new ArrayList<>();
        if (r == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(r);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            res.add(n.val);
            if (n.right != null) st.push(n.right);
            if (n.left != null) st.push(n.left);
        }
        return res;
    }
}
