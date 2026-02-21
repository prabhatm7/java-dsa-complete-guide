// LC 746. Min Cost Climbing Stairs
// Approach: Top-down memoization. minCost(i) = cost[i] + min(minCost(i-1), minCost(i-2))
// Start from top (index n), can step from n-1 or n-2
// Time: O(n) | Space: O(n)
import java.util.*;

class MinCostClimbingStairs {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return dfs(cost, cost.length);
    }

    private int dfs(int[] cost, int i) {
        if (i <= 1) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int res = Math.min(dfs(cost, i - 1) + cost[i - 1], dfs(cost, i - 2) + cost[i - 2]);
        memo.put(i, res);
        return res;
    }
}
