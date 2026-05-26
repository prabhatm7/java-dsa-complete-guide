/*
 * Problem: Reverse Nodes in k-Group
 *
 * Intuition: Find k-th node; if exists, reverse first k; recurse for rest and attach.
 * Time: O(n)  Space: O(n/k) recursion
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class ReverseInGroupsK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        for (int i = 0; i < k; i++) {
            if (t == null) return head;
            t = t.next;
        }
        ListNode prev = null, cur = head;
        for (int i = 0; i < k; i++) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur; cur = nxt;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
