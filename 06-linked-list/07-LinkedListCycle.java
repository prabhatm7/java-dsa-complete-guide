// LC 141. Linked List Cycle
// Approach: Floyd's cycle detection - slow (1 step) and fast (2 steps) pointers
// Time: O(n) | Space: O(1)
class LinkedListCycle {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
