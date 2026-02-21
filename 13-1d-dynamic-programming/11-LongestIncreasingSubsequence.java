// LC 300. Longest Increasing Subsequence
// Approach: Top-down memoization. dfs(i) = length of LIS starting at index i.
// For each j > i where nums[j] > nums[i], take max(1 + dfs(j)).
// Time: O(n^2) | Space: O(n)
import java.util.*;

class LongestIncreasingSubsequence {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dfs(nums, i));
        return max;
    }

    private int dfs(int[] nums, int i) {
        if (memo[i] != 0) return memo[i];
        memo[i] = 1;
        for (int j = i + 1; j < nums.length; j++)
            if (nums[j] > nums[i])
                memo[i] = Math.max(memo[i], 1 + dfs(nums, j));
        return memo[i];
    }
}
