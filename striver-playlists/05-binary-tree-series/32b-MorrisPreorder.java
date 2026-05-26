/*
 * Problem: Morris Preorder Traversal (O(1) space).
 *
 * Intuition: Thread predecessor's right to current; emit before threading (preorder); unthread on revisit.
 * Time: O(n)  Space: O(1)
 */
import java.util.*;
class TreeNode32b { int val; TreeNode32b left, right; TreeNode32b(int v){val=v;} }
public class MorrisPreorder {
    public List<Integer> preorder(TreeNode32b root) {
        List<Integer> res = new ArrayList<>();
        TreeNode32b cur = root;
        while (cur != null) {
            if (cur.left == null) { res.add(cur.val); cur = cur.right; }
            else {
                TreeNode32b pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) { res.add(cur.val); pre.right = cur; cur = cur.left; }
                else { pre.right = null; cur = cur.right; }
            }
        }
        return res;
    }
}
