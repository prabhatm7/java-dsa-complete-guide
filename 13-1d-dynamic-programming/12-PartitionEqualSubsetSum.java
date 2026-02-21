// LC 416. Partition Equal Subset Sum
// Approach: Top-down memoization. Reduce to: can we find subset summing to totalSum/2?
// dfs(i, target) = using nums[i..end], can we reach target?
// Pick or skip current element.
// Time: O(n * sum) | Space: O(n * sum)
import java.util.*;

class PartitionEqualSubsetSum {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        return dfs(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;
        String key = i + "," + target;
        if (memo.containsKey(key)) return memo.get(key);
        boolean res = dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
        memo.put(key, res);
        return res;
    }
}
