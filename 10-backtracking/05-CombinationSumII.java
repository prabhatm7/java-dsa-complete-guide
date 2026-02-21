// LC 40. Combination Sum II (each number used once, has duplicates)
// Approach: Sort. Backtrack. Skip duplicates at same level.
// Time: O(2^n) | Space: O(n)
import java.util.*;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> curr, List<List<Integer>> res) {
        if (remain == 0) { res.add(new ArrayList<>(curr)); return; }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break;
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
