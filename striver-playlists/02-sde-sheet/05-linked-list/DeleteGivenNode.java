/*
 * Problem: Delete a node (not tail) given only access to it.
 *
 * Intuition: Copy next node's value into current; skip next node.
 * Time: O(1)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class DeleteGivenNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
