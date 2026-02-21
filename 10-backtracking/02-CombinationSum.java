// LC 39. Combination Sum
// Approach: Backtracking - can reuse same element (don't increment index)
// Time: O(n^(t/m)) where t=target, m=min candidate | Space: O(t/m)
import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> curr, List<List<Integer>> res) {
        if (remain == 0) { res.add(new ArrayList<>(curr)); return; }
        if (remain < 0) return;
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, remain - nums[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
