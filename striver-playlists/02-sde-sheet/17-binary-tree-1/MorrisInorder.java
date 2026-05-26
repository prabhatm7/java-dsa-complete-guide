/*
 * Problem: Morris Inorder Traversal (O(1) space).
 *
 * Intuition: Use predecessor's right pointer as a temporary thread back to current.
 * Time: O(n)  Space: O(1)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class MorrisInorder {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) { res.add(cur.val); cur = cur.right; }
            else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) { pre.right = cur; cur = cur.left; }
                else { pre.right = null; res.add(cur.val); cur = cur.right; }
            }
        }
        return res;
    }
}
