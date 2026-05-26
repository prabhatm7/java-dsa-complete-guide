/*
 * Problem: Iterative Postorder (2 stacks).
 *
 * Intuition: Stack-1 root-right-left order; transfer to stack-2; pop all = postorder.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class IterativePostorder2Stacks {
    public List<Integer> postorder(TreeNode r) {
        List<Integer> res = new ArrayList<>();
        if (r == null) return res;
        Deque<TreeNode> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
        s1.push(r);
        while (!s1.isEmpty()) {
            TreeNode n = s1.pop();
            s2.push(n);
            if (n.left != null) s1.push(n.left);
            if (n.right != null) s1.push(n.right);
        }
        while (!s2.isEmpty()) res.add(s2.pop().val);
        return res;
    }
}
