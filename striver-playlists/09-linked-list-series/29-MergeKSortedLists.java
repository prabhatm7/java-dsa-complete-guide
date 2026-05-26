/*
 * Problem: Merge K Sorted Lists.
 *
 * Intuition: Min-heap of current heads; pop smallest, push its next.
 * Time: O(N log k)  Space: O(k)
 */
import java.util.*;
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) if (l != null) pq.offer(l);
        ListNode d = new ListNode(0), c = d;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            c.next = n; c = c.next;
            if (n.next != null) pq.offer(n.next);
        }
        return d.next;
    }
}
