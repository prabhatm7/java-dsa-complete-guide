/*
 * Problem: Recursive Postorder.
 *
 * Intuition: Left, Right, Root.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class RecursivePostorder {
    public List<Integer> postorder(TreeNode r) { List<Integer> a = new ArrayList<>(); go(r, a); return a; }
    private void go(TreeNode n, List<Integer> r) {
        if (n == null) return;
        go(n.left, r); go(n.right, r); r.add(n.val);
    }
}
