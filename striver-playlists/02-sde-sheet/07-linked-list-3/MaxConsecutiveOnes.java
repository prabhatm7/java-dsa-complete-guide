/*
 * Problem: Max Consecutive Ones
 *
 * Intuition: Reset counter on 0; track max.
 * Time: O(n)  Space: O(1)
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] a) {
        int c = 0, best = 0;
        for (int x : a) { if (x == 1) { c++; if (c > best) best = c; } else c = 0; }
        return best;
    }
}
