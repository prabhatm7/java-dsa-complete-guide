// LC 21. Merge Two Sorted Lists
// Approach: Dummy head, compare and link smaller node
// Time: O(n + m) | Space: O(1)
class MergeTwoSortedLists {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
            else { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
