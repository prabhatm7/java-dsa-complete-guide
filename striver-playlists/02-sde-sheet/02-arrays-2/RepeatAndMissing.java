/*
 * Problem: Find the Missing and Repeating Number
 * Array of size n with values in [1..n], one number repeats and one is missing.
 *
 * Intuition: Use sum and sum of squares; solve two linear equations for (x - y) and (x^2 - y^2).
 * Time: O(n)  Space: O(1)
 */
public class RepeatAndMissing {
    public int[] findTwoElement(int[] a) {
        long n = a.length;
        long sN = n * (n + 1) / 2, s2N = n * (n + 1) * (2 * n + 1) / 6;
        long s = 0, s2 = 0;
        for (int x : a) { s += x; s2 += (long) x * x; }
        long val1 = s - sN;
        long val2 = (s2 - s2N) / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[]{(int) x, (int) y};
    }
}
