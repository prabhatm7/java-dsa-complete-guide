// LC 338. Counting Bits
// Approach: dp[i] = dp[i >> 1] + (i & 1). Right shift gives known count, add LSB.
// Time: O(n) | Space: O(n)
class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }
}
