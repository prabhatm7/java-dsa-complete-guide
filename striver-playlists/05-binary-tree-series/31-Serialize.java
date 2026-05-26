/*
 * Problem: Serialize and Deserialize Binary Tree.
 *
 * Intuition: Preorder with null markers.
 * Time: O(n)  Space: O(n)
 */
class TreeNode { int val; TreeNode left, right; TreeNode(int v){val=v;} }
public class Serialize {
    public String serialize(TreeNode r) {
        StringBuilder sb = new StringBuilder();
        ser(r, sb);
        return sb.toString();
    }
    private void ser(TreeNode n, StringBuilder sb) {
        if (n == null) { sb.append("#,"); return; }
        sb.append(n.val).append(',');
        ser(n.left, sb); ser(n.right, sb);
    }
    int i = 0;
    public TreeNode deserialize(String s) { return des(s.split(",")); }
    private TreeNode des(String[] t) {
        if (t[i].equals("#")) { i++; return null; }
        TreeNode n = new TreeNode(Integer.parseInt(t[i++]));
        n.left = des(t); n.right = des(t);
        return n;
    }
}
