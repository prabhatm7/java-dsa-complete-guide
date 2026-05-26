/*
 * Problem: Iterative Postorder (1 stack).
 *
 * Intuition: Use a "last visited" pointer; visit root only when right subtree done.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class IterativePostorder1Stack {
    public List<Integer> postorder(TreeNode r) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = r, last = null;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            TreeNode peek = st.peek();
            if (peek.right == null || peek.right == last) { res.add(peek.val); last = st.pop(); }
            else cur = peek.right;
        }
        return res;
    }
}
