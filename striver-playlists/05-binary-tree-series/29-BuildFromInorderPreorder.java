/*
 * Problem: Build Tree from Inorder + Preorder.
 *
 * Intuition: pre[0]=root; split inorder around it; recurse.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BuildFromInorderPreorder {
    Map<Integer, Integer> idx = new HashMap<>();
    int p = 0;
    public TreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) idx.put(in[i], i);
        return go(pre, 0, in.length - 1);
    }
    private TreeNode go(int[] pre, int l, int r) {
        if (l > r) return null;
        TreeNode n = new TreeNode(pre[p++]);
        int m = idx.get(n.val);
        n.left = go(pre, l, m - 1);
        n.right = go(pre, m + 1, r);
        return n;
    }
}
