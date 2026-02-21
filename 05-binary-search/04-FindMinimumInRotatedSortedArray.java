// LC 153. Find Minimum in Rotated Sorted Array
// Approach: Binary search. If mid > right, min is in right half. Else in left half.
// Time: O(log n) | Space: O(1)
class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
