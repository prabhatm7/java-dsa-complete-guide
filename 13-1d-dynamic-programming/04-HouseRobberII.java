// LC 213. House Robber II (circular)
// Approach: Top-down memoization. Houses in circle -> can't rob both first and last.
// Run memoized House Robber on nums[0..n-2] and nums[1..n-1], take max.
// Time: O(n) | Space: O(n)
import java.util.*;

class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, end, start, memo);
    }

    private int dfs(int[] nums, int i, int start, Map<Integer, Integer> memo) {
        if (i < start) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int res = Math.max(dfs(nums, i - 1, start, memo), dfs(nums, i - 2, start, memo) + nums[i]);
        memo.put(i, res);
        return res;
    }
}
