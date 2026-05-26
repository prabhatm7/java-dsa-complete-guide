/*
 * Problem: Boundary Traversal of Binary Tree (anti-clockwise).
 *
 * Intuition: Root + left boundary (top-down, excl leaves) + leaves (LtoR) + right boundary (bottom-up, excl leaves).
 * Time: O(n)  Space: O(h)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);
        addLeft(root.left, res);
        addLeaves(root, res);
        addRight(root.right, res);
        return res;
    }
    private boolean isLeaf(TreeNode n) { return n.left == null && n.right == null; }
    private void addLeft(TreeNode n, List<Integer> r) {
        while (n != null) {
            if (!isLeaf(n)) r.add(n.val);
            n = n.left != null ? n.left : n.right;
        }
    }
    private void addRight(TreeNode n, List<Integer> r) {
        Deque<Integer> st = new ArrayDeque<>();
        while (n != null) {
            if (!isLeaf(n)) st.push(n.val);
            n = n.right != null ? n.right : n.left;
        }
        while (!st.isEmpty()) r.add(st.pop());
    }
    private void addLeaves(TreeNode n, List<Integer> r) {
        if (n == null) return;
        if (isLeaf(n)) { r.add(n.val); return; }
        addLeaves(n.left, r); addLeaves(n.right, r);
    }
}
