// LC 287. Find the Duplicate Number
// Approach: Floyd's cycle detection on value-as-pointer graph
// Phase 1: Find intersection. Phase 2: Find cycle entrance.
// Time: O(n) | Space: O(1)
class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
