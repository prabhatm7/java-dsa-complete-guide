// LC 167. Two Sum II - Input Array Is Sorted
// Approach: Two pointers - if sum too big, move right left; if too small, move left right
// Time: O(n) | Space: O(1)
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum < target) l++;
            else r--;
        }
        return new int[]{};
    }
}
