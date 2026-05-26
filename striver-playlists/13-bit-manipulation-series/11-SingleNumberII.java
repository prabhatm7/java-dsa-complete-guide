/*
 * Problem: Single Number II — every other element appears three times.
 *
 * Intuition: Track ones/twos bits with formulas using XOR/AND.
 * Time: O(n)  Space: O(1)
 */
public class SingleNumberII {
    public int singleNumber(int[] a) {
        int ones = 0, twos = 0;
        for (int x : a) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }
}
