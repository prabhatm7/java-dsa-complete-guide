/*
 * Problem: Build Tree from Inorder + Postorder.
 *
 * Intuition: post[last]=root; right subtree first (consume from right of postorder).
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class BuildFromInorderPostorder {
    Map<Integer, Integer> idx = new HashMap<>();
    int p;
    public TreeNode buildTree(int[] in, int[] post) {
        for (int i = 0; i < in.length; i++) idx.put(in[i], i);
        p = post.length - 1;
        return go(post, 0, in.length - 1);
    }
    private TreeNode go(int[] post, int l, int r) {
        if (l > r) return null;
        TreeNode n = new TreeNode(post[p--]);
        int m = idx.get(n.val);
        n.right = go(post, m + 1, r);
        n.left = go(post, l, m - 1);
        return n;
    }
}
