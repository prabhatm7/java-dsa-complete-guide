/*
 * Problem: Largest Divisible Subset.
 *
 * Intuition: Sort; LIS-style dp on divisibility (a[j] % a[i] == 0).
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class LongestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int[] dp = new int[n], par = new int[n];
        Arrays.fill(par, -1);
        int best = 0, bestIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (a[i] % a[j] == 0 && dp[j] + 1 > dp[i]) { dp[i] = dp[j] + 1; par[i] = j; }
            if (dp[i] > best) { best = dp[i]; bestIdx = i; }
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = bestIdx; i != -1; i = par[i]) res.addFirst(a[i]);
        return res;
    }
}
