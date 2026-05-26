/*
 * Problem: Divide Two Integers without using division or mod.
 *
 * Intuition: Bit shift: subtract largest multiple of divisor that's <= dividend at each step.
 * Time: O(log^2 n)  Space: O(1)
 */
public class DivideTwoIntegers {
    public int divide(int dvd, int dvs) {
        if (dvd == Integer.MIN_VALUE && dvs == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dvd), b = Math.abs((long) dvs);
        long ans = 0;
        while (a >= b) {
            long t = b, m = 1;
            while ((t << 1) <= a) { t <<= 1; m <<= 1; }
            ans += m;
            a -= t;
        }
        return (dvd > 0) == (dvs > 0) ? (int) ans : (int) -ans;
    }
}
