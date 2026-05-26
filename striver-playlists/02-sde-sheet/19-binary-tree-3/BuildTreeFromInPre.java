/*
 * Problem: Construct Binary Tree from Preorder and Inorder.
 *
 * Intuition: Preorder[0] is root; locate in inorder to split left/right subtree ranges; recurse.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BuildTreeFromInPre {
    Map<Integer, Integer> idx = new HashMap<>();
    int p = 0;
    public TreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) idx.put(in[i], i);
        return go(pre, 0, in.length - 1);
    }
    private TreeNode go(int[] pre, int l, int r) {
        if (l > r) return null;
        int v = pre[p++];
        TreeNode n = new TreeNode(v);
        int m = idx.get(v);
        n.left = go(pre, l, m - 1);
        n.right = go(pre, m + 1, r);
        return n;
    }
}
