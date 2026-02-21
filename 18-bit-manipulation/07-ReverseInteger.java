// LC 7. Reverse Integer
// Approach: Pop last digit (x % 10), push to result. Check overflow before pushing.
// Time: O(log x) | Space: O(1)
class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            result = result * 10 + digit;
        }
        return result;
    }
}
