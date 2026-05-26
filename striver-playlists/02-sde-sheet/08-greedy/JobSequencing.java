/*
 * Problem: Job Sequencing — each job has deadline & profit; do one per slot; maximize profit.
 *
 * Intuition: Sort by profit desc; for each job, place it in the latest free slot <= deadline.
 * Time: O(n^2)  Space: O(maxDeadline)
 */
import java.util.*;
public class JobSequencing {
    public int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        int maxD = 0;
        for (int[] j : jobs) maxD = Math.max(maxD, j[1]);
        int[] slot = new int[maxD + 1];
        Arrays.fill(slot, -1);
        int cnt = 0, profit = 0;
        for (int[] j : jobs) {
            for (int t = j[1]; t > 0; t--) {
                if (slot[t] == -1) { slot[t] = j[0]; cnt++; profit += j[2]; break; }
            }
        }
        return new int[]{cnt, profit};
    }
}
