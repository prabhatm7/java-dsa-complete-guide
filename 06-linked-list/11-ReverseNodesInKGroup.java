// LC 25. Reverse Nodes in K-Group
// Approach: Count k nodes, reverse the group, recursively process rest
// Time: O(n) | Space: O(n/k) recursion stack
class ReverseNodesInKGroup {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) { curr = curr.next; count++; }
        if (count < k) return head;
        ListNode prev = reverseKGroup(curr, k);
        while (count-- > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
