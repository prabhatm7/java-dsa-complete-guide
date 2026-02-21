// LC 19. Remove Nth Node From End of List
// Approach: Two pointers - advance first pointer n steps ahead, then move both until end
// Time: O(n) | Space: O(1)
class RemoveNthNodeFromEndOfList {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
