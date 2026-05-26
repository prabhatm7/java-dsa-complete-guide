/*
 * Problem: Search element in Linked List.
 *
 * Intuition: Linear scan.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class SearchInLL {
    public boolean search(ListNode h, int t) {
        while (h != null) { if (h.val == t) return true; h = h.next; }
        return false;
    }
}
