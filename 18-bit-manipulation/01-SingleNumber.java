// LC 136. Single Number
// Approach: XOR all numbers. a ^ a = 0, a ^ 0 = a. Duplicate pairs cancel out.
// Time: O(n) | Space: O(1)
class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) result ^= n;
        return result;
    }
}
