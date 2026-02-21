// LC 23. Merge K Sorted Lists
// Approach: Min-heap (PriorityQueue) of list heads. Poll min, add its next.
// Time: O(n log k) where n = total nodes | Space: O(k)
import java.util.*;

class MergeKSortedLists {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) if (l != null) pq.offer(l);
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
