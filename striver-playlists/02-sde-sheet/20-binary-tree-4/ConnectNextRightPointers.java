/*
 * Problem: Populate Next Right Pointers in Each Node (perfect BT).
 *
 * Intuition: BFS level by level; link siblings; or use already-established next pointers for O(1) space.
 * Time: O(n)  Space: O(1)
 */
class PNode { int val; PNode left, right, next; PNode(int v){val=v;} }
public class ConnectNextRightPointers {
    public PNode connect(PNode root) {
        PNode lvl = root;
        while (lvl != null && lvl.left != null) {
            PNode cur = lvl;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            lvl = lvl.left;
        }
        return root;
    }
}
