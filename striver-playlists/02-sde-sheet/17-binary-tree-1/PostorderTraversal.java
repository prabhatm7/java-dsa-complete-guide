/*
 * Problem: Binary Tree Postorder Traversal (iterative, single stack).
 *
 * Intuition: Modified preorder root-right-left; reverse to get left-right-root.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class PostorderTraversal {
    public List<Integer> postorder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            res.addFirst(n.val);
            if (n.left != null) st.push(n.left);
            if (n.right != null) st.push(n.right);
        }
        return res;
    }
}
