// LC 202. Happy Number
// Approach: Floyd's cycle detection. Compute digit square sum. If reaches 1, happy. If cycle, not.
// Time: O(log n) | Space: O(1)
class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) { int d = n % 10; sum += d * d; n /= 10; }
        return sum;
    }
}
