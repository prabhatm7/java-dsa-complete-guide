// LC 66. Plus One
// Approach: Start from last digit. If < 9, increment and return. Else set to 0, carry over.
// If all 9s, prepend 1.
// Time: O(n) | Space: O(1) or O(n) for new array
class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) { digits[i]++; return digits; }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
