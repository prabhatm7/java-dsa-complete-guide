// LC 494. Target Sum
// Approach: Top-down memoization. dfs(i, currSum) = ways to reach target from index i with currSum.
// At each index, add (+nums[i]) or subtract (-nums[i]).
// Time: O(n * totalSum) | Space: O(n * totalSum)
import java.util.*;

class TargetSum {
    private Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int i, int currSum, int target) {
        if (i == nums.length) return currSum == target ? 1 : 0;
        String key = i + "," + currSum;
        if (memo.containsKey(key)) return memo.get(key);
        int res = dfs(nums, i + 1, currSum + nums[i], target) +
                  dfs(nums, i + 1, currSum - nums[i], target);
        memo.put(key, res);
        return res;
    }
}
