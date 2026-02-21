// LC 53. Maximum Subarray (Kadane's Algorithm)
// Approach: Track current sum. If negative, reset to 0. Track max sum.
// Time: O(n) | Space: O(1)
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = 0;
        for (int n : nums) {
            currSum = Math.max(n, currSum + n);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
