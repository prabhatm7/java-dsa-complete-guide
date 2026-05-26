/*
 * Problem: Nth Root of M.
 *
 * Intuition: BS on answer; carefully exponentiate to avoid overflow.
 * Time: O(log m * n)  Space: O(1)
 */
public class NthRoot {
    public int NthRoot(int n, int m) {
        int lo = 1, hi = m;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int c = check(mid, n, m);
            if (c == 0) return mid;
            if (c == -1) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }
    private int check(long mid, int n, int m) {
        long val = 1;
        for (int i = 0; i < n; i++) { val *= mid; if (val > m) return 1; }
        return val == m ? 0 : -1;
    }
}
