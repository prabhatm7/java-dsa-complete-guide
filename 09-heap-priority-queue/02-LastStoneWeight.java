// LC 1046. Last Stone Weight
// Approach: Max-heap. Poll two largest, push difference if non-zero.
// Time: O(n log n) | Space: O(n)
import java.util.*;

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) maxHeap.offer(s);
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll(), b = maxHeap.poll();
            if (a != b) maxHeap.offer(a - b);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
