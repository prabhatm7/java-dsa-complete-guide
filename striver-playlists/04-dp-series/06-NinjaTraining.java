/*
 * Problem: Ninja Training — pick one of 3 activities each day, can't repeat consecutive; maximize points.
 *
 * Intuition: dp[day][last] = points[day][k] + dp[day-1][k] over k != last; last=3 means no restriction.
 * Time: O(n*4*3)  Space: O(4)
 */
public class NinjaTraining {
    public int ninjaTraining(int n, int[][] p) {
        int[] prev = new int[4];
        prev[0] = Math.max(p[0][1], p[0][2]);
        prev[1] = Math.max(p[0][0], p[0][2]);
        prev[2] = Math.max(p[0][0], p[0][1]);
        prev[3] = Math.max(p[0][0], Math.max(p[0][1], p[0][2]));
        for (int day = 1; day < n; day++) {
            int[] cur = new int[4];
            for (int last = 0; last < 4; last++) {
                int best = 0;
                for (int k = 0; k < 3; k++) if (k != last) best = Math.max(best, p[day][k] + prev[k]);
                cur[last] = best;
            }
            prev = cur;
        }
        return prev[3];
    }
}
