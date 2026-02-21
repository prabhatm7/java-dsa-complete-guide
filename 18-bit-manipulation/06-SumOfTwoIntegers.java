// LC 371. Sum of Two Integers (without + or -)
// Approach: a XOR b = sum without carry. (a AND b) << 1 = carry. Repeat until no carry.
// Time: O(32) | Space: O(1)
class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
