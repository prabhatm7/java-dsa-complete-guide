/*
 * Problem: Iterative Inorder.
 *
 * Intuition: Push all lefts; pop, visit, move to right.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class IterativeInorder {
    public List<Integer> inorder(TreeNode r) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode c = r;
        while (c != null || !st.isEmpty()) {
            while (c != null) { st.push(c); c = c.left; }
            c = st.pop();
            res.add(c.val);
            c = c.right;
        }
        return res;
    }
}
