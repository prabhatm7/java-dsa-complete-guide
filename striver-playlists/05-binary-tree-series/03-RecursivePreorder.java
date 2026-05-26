/*
 * Problem: Recursive Preorder.
 *
 * Intuition: Root, Left, Right.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class RecursivePreorder {
    public List<Integer> preorder(TreeNode r) { List<Integer> a = new ArrayList<>(); go(r, a); return a; }
    private void go(TreeNode n, List<Integer> r) {
        if (n == null) return;
        r.add(n.val); go(n.left, r); go(n.right, r);
    }
}
