/*
 * Problem: Introduction to Priority Queue.
 *
 * Intuition: PQ is a binary heap; logarithmic insert/extract; min-heap by default in Java with reverse comparator for max.
 * Time: O(log n) push/pop, O(1) peek  Space: O(n)
 */
import java.util.*;
public class IntroToPQ {
    public void demo() {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        min.offer(3); min.offer(1); min.offer(2);
        max.offer(3); max.offer(1); max.offer(2);
    }
}
