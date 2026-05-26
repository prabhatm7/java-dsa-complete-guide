/*
 * Problem: Ceil and Floor in BST.
 *
 * Intuition: Walk down; if node==target return; if val < target, candidate for floor & go right; vice versa for ceil.
 * Time: O(h)  Space: O(1)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class CeilFloorInBST {
    public int ceil(TreeNode r, int x) {
        int c = -1;
        while (r != null) {
            if (r.val == x) return x;
            if (r.val > x) { c = r.val; r = r.left; } else r = r.right;
        }
        return c;
    }
    public int floor(TreeNode r, int x) {
        int f = -1;
        while (r != null) {
            if (r.val == x) return x;
            if (r.val < x) { f = r.val; r = r.right; } else r = r.left;
        }
        return f;
    }
}
