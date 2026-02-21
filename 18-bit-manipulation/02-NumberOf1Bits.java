// LC 191. Number of 1 Bits
// Approach: n & (n-1) clears lowest set bit. Count iterations until 0.
// Time: O(32) | Space: O(1)
class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
