/*
 * Problem: House Robber II — circular (first and last adjacent).
 *
 * Intuition: Run linear House Robber twice — exclude first or exclude last; max of two.
 * Time: O(n)  Space: O(1)
 */
public class HouseRobberII {
    public int rob(int[] a) {
        if (a.length == 1) return a[0];
        return Math.max(robRange(a, 0, a.length - 2), robRange(a, 1, a.length - 1));
    }
    private int robRange(int[] a, int l, int r) {
        int p2 = 0, p1 = 0;
        for (int i = l; i <= r; i++) { int c = Math.max(p1, p2 + a[i]); p2 = p1; p1 = c; }
        return p1;
    }
}
