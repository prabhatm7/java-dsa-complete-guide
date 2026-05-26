/*
 * Problem: Construct Binary Tree from Inorder and Postorder.
 *
 * Intuition: Postorder[last] is root; locate in inorder; build right subtree first since we consume from right of postorder.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BuildTreeFromInPost {
    Map<Integer, Integer> idx = new HashMap<>();
    int p;
    public TreeNode buildTree(int[] in, int[] post) {
        for (int i = 0; i < in.length; i++) idx.put(in[i], i);
        p = post.length - 1;
        return go(post, 0, in.length - 1);
    }
    private TreeNode go(int[] post, int l, int r) {
        if (l > r) return null;
        int v = post[p--];
        TreeNode n = new TreeNode(v);
        int m = idx.get(v);
        n.right = go(post, m + 1, r);
        n.left = go(post, l, m - 1);
        return n;
    }
}
