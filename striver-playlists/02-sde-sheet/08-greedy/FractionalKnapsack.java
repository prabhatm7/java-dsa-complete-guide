/*
 * Problem: Fractional Knapsack
 *
 * Intuition: Sort by value/weight ratio descending; take full items until capacity exhausted, then a fraction.
 * Time: O(n log n)  Space: O(1)
 */
import java.util.*;
public class FractionalKnapsack {
    public double fractionalKnapsack(int W, int[][] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        double v = 0;
        for (int[] it : items) {
            if (it[1] <= W) { v += it[0]; W -= it[1]; }
            else { v += (double) it[0] * W / it[1]; break; }
        }
        return v;
    }
}
