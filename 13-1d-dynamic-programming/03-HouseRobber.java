// LC 198. House Robber
// Approach: Top-down memoization. rob(i) = max(rob(i-1), rob(i-2) + nums[i])
// Either skip current house or rob it + skip previous
// Time: O(n) | Space: O(n)
import java.util.*;

class HouseRobber {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    private int dfs(int[] nums, int i) {
        if (i < 0) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int res = Math.max(dfs(nums, i - 1), dfs(nums, i - 2) + nums[i]);
        memo.put(i, res);
        return res;
    }
}
