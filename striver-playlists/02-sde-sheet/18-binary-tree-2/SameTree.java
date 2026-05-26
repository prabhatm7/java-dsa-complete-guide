/*
 * Problem: Same Tree — check identical structure & values.
 *
 * Intuition: Recurse — both null OK; both non-null, equal vals, equal subtrees.
 * Time: O(n)  Space: O(h)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class SameTree {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
