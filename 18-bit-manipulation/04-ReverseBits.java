// LC 190. Reverse Bits
// Approach: Extract each bit from right, place in reversed position from left.
// Time: O(32) | Space: O(1)
class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
}
