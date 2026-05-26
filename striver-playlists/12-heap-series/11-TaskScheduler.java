/*
 * Problem: Task Scheduler with cooldown n.
 *
 * Intuition: Max-heap by count; per cycle process up to n+1 tasks; refill heap with non-empty.
 * Time: O(N log 26)  Space: O(26)
 */
import java.util.*;
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks) cnt[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : cnt) if (x > 0) pq.offer(x);
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) tmp.add(pq.poll() - 1);
                time++;
                if (pq.isEmpty() && tmp.stream().allMatch(x -> x == 0)) break;
            }
            for (int x : tmp) if (x > 0) pq.offer(x);
        }
        return time;
    }
}
