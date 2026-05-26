/*
 * Problem: Count Subsets with Sum K.
 *
 * Intuition: dp[s] = number of ways; for each num iterate s desc, dp[s] += dp[s-num].
 * Time: O(n*k)  Space: O(k)
 */
public class CountSubsetsSumK {
    public int countSubsets(int[] a, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int x : a) for (int s = k; s >= x; s--) dp[s] += dp[s - x];
        return dp[k];
    }
}
