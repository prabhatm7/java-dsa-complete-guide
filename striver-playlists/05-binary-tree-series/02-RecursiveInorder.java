/*
 * Problem: Recursive Inorder (Left, Root, Right).
 *
 * Intuition: Visit left subtree, then root, then right subtree.
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class RecursiveInorder {
    public List<Integer> inorder(TreeNode r) {
        List<Integer> res = new ArrayList<>();
        go(r, res);
        return res;
    }
    private void go(TreeNode n, List<Integer> r) {
        if (n == null) return;
        go(n.left, r); r.add(n.val); go(n.right, r);
    }
}
