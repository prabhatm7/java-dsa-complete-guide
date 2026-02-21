// LC 152. Maximum Product Subarray
// Approach: Top-down memoization tracking both max and min products ending at index i.
// dfs(i) returns {maxProduct, minProduct} ending at i.
// Min can become max when multiplied by negative number.
// Time: O(n) | Space: O(n)
class MaximumProductSubarray {
    private int[][] memo; // memo[i] = {maxEndingHere, minEndingHere}

    public int maxProduct(int[] nums) {
        int n = nums.length;
        memo = new int[n][2];
        boolean[] visited = new boolean[n];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dfs(nums, i, visited);
            result = Math.max(result, memo[i][0]);
        }
        return result;
    }

    private void dfs(int[] nums, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        if (i == 0) {
            memo[i][0] = nums[0];
            memo[i][1] = nums[0];
            return;
        }
        dfs(nums, i - 1, visited);
        int prevMax = memo[i - 1][0], prevMin = memo[i - 1][1];
        int a = prevMax * nums[i], b = prevMin * nums[i], c = nums[i];
        memo[i][0] = Math.max(c, Math.max(a, b));
        memo[i][1] = Math.min(c, Math.min(a, b));
    }
}
