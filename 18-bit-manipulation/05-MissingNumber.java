// LC 268. Missing Number
// Approach: XOR indices 0..n with all array values. Missing number remains.
// Or: sum(0..n) - sum(array)
// Time: O(n) | Space: O(1)
class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++)
            xor ^= i ^ nums[i];
        return xor;
    }
}
