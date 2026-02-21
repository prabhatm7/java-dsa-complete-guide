// LC 312. Burst Balloons
// Approach: Top-down memoization. dfs(left, right) = max coins bursting balloons between left and right (exclusive).
// Try each k in (left, right) as the LAST balloon to burst in this range.
// Coins = arr[left]*arr[k]*arr[right] + dfs(left, k) + dfs(k, right).
// Time: O(n^3) | Space: O(n^2)
class BurstBalloons {
    private Integer[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
        memo = new Integer[n + 2][n + 2];
        return dfs(arr, 0, n + 1);
    }

    private int dfs(int[] arr, int left, int right) {
        if (right - left < 2) return 0;
        if (memo[left][right] != null) return memo[left][right];
        int max = 0;
        for (int k = left + 1; k < right; k++) {
            int coins = arr[left] * arr[k] * arr[right] + dfs(arr, left, k) + dfs(arr, k, right);
            max = Math.max(max, coins);
        }
        memo[left][right] = max;
        return max;
    }
}
