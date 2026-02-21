// LC 70. Climbing Stairs
// Approach: Top-down memoization. climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
// Base: n<=2 -> return n
// Time: O(n) | Space: O(n)
import java.util.*;

class ClimbingStairs {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, res);
        return res;
    }
}
